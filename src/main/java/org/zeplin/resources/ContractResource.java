package org.zeplin.resources;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.zeplin.repository.CachedRepository;

import java.util.List;

/**
 * Created by rbrooks3 on 6/21/16.
 */
public abstract class ContractResource<X, Y extends CachedRepository<X>> implements CrudResource<X> {

    protected final Y repository;

    protected ContractResource(final Y repository) {

        this.repository = repository;
    }

    public HttpEntity<List<X>> getAll() {

        return ResponseSupport.statusOrNotFound(repository.findAll(), HttpStatus.OK);
    }

    public HttpEntity<X> get(@PathVariable final String id) {

       return ResponseSupport.statusOrNotFound(repository.findById(id), HttpStatus.OK);
    }

    public HttpEntity<X> create(@RequestBody final X resource) {

        return ResponseSupport.statusOrNotFound(repository.save(resource), HttpStatus.CREATED);
    }

    public HttpEntity<X> update(@PathVariable final String id, @RequestBody final X resource) {

        return ResponseSupport.statusOrNotFound(repository.update(id, resource), HttpStatus.OK);
    }
}
