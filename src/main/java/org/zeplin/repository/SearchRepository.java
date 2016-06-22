package org.zeplin.repository;

import java.util.List;

/**
 * Created by rbrooks3 on 6/21/16.
 */
public interface SearchRepository<X, Y extends SearchContext> extends CachedRepository<X> {

    List<X> search(Y searchContext);
}
