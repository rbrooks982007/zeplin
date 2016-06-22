package org.zeplin.resources;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * Created by rbrooks3 on 6/21/16.
 */
public interface CrudResource<T> {

    @RequestMapping(method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    HttpEntity<List<T>> getAll();

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    HttpEntity<T> get(@PathVariable String id);

    @RequestMapping(method = POST, produces = MediaType.APPLICATION_JSON_VALUE)
    HttpEntity<T> create(@RequestBody T resource);

    @RequestMapping(path = "/{id}", method = PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    HttpEntity<T> update(@PathVariable String id, @RequestBody T resource);
}
