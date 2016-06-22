package org.zeplin.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zeplin.model.Invoice;
import org.zeplin.repository.impl.InvoiceRepositoryImpl;
import org.zeplin.repository.impl.InvoiceSearchContext;

import java.net.URLDecoder;
import java.util.List;

/**
 * Created by rbrooks3 on 6/20/16.
 */
@RestController
@RequestMapping("/invoices")
public class InvoiceResource extends ContractResource<Invoice, InvoiceRepositoryImpl> {

    @Autowired
    public InvoiceResource(final InvoiceRepositoryImpl repository) {
        super(repository);
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<List<Invoice>> search(@RequestParam(required = false) final String customerId,
                                            @RequestParam(required = false) final String contractId) {

        ResponseEntity<List<Invoice>> responseEntity;

        if(customerId == null && contractId == null) {
            responseEntity = ResponseSupport.statusOrNotFound(repository.findAll(), HttpStatus.OK);
        } else {
            try {
                responseEntity = ResponseSupport.statusOrNotFound(repository.search(
                        new InvoiceSearchContext(
                                contractId != null ? URLDecoder.decode(contractId, "utf-8") : null,
                                customerId)), HttpStatus.OK);
            } catch (Exception ex) {
                throw new IllegalArgumentException("Failed to decode contractId", ex);
            }

        }

        return responseEntity;
    }

}
