package org.zeplin.repository;

import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.zeplin.model.Identity;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by rbrooks3 on 6/21/16.
 */
public abstract class CrudCacheRepository<X extends Identity> implements CachedRepository<X> {

    protected final LoadingCache<String, Optional<X>> cache;
    private final static long MAX_CACHE_SIZE = 1000;
    private final static long CACHE_EXPIRE_TIME = 24;

    public CrudCacheRepository() {

        this.cache = CacheBuilder.newBuilder()
                                 .maximumSize(MAX_CACHE_SIZE)
                                 .expireAfterAccess(CACHE_EXPIRE_TIME, TimeUnit.HOURS)
                                 .build(new CacheLoader<String, Optional<X>>() {

                                     @Override
                                     public Optional<X> load(String id) throws Exception {
                                         return Optional.fromNullable(getBackingCache().get(id));
                                     }
                                 });
    }

    public abstract WeakHashMap<String, X> getBackingCache();

    public List<X> findAll() {

        List<X> entities = new ArrayList<X>();
        try {
            for(Optional<X> optional : cache.getAll(getBackingCache().keySet()).values()) {
                entities.add(optional.get());
            }
        } catch (ExecutionException ex) {
            entities = null;
        }


        return entities;
    }

    public X findById(final String id) {

        X result;
        try {
            result = cache.get(id).get();
        } catch (ExecutionException ex) {
            result = null;
        }

        return result;
    }

    public X save(final X entity) {

        cache.put(entity.getId(), Optional.fromNullable(entity));
        return entity;
    }

    public X update(final String id, final X entity) {
        if(findById(id) == null) {
            return null;
        }

        cache.put(entity.getId(), Optional.fromNullable(entity));
        return entity;
    }
}
