package org.zeplin.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by rbrooks3 on 6/21/16.
 */
public final class ResponseSupport {

    public  static <T> ResponseEntity<T> statusOrNotFound(T entity, HttpStatus status) {
        ResponseEntity<T> responseEntity =  new ResponseEntity<T>(HttpStatus.NOT_FOUND);
        if(entity != null) {
            responseEntity = new ResponseEntity<T>(entity, status);
        }

        return responseEntity;
    }
}
