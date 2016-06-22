package org.zeplin.resources;

/**
 * Created by rbrooks3 on 6/20/16.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zeplin.model.contracts.Customer;
import org.zeplin.repository.impl.CustomerRepositoryImpl;

/**
 * REST controller for VodAsset documents.
 *
 * @author bcalaci
 */
@RestController
@RequestMapping("/customers")
public class CustomerResource extends ContractResource<Customer, CustomerRepositoryImpl> {

    @Autowired
    public CustomerResource(final CustomerRepositoryImpl customerRepository) {

        super(customerRepository);
    }

}
