package org.zeplin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.zeplin.model.Invoice;

/**
 * Created by rbrooks3 on 6/20/16.
 */
public interface InvoiceRepository extends MongoRepository<Invoice, String>, CachedRepository<Invoice> {

}
