package org.zeplin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.zeplin.model.contracts.Customer;

/**
 * Created by rbrooks3 on 6/20/16.
 */
public interface CustomerRepository extends MongoRepository<Customer, String>, CachedRepository<Customer> {

}
