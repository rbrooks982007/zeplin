package org.zeplin.repository.impl;

import org.zeplin.repository.SearchContext;

/**
 * Created by rbrooks3 on 6/21/16.
 */
public class InvoiceSearchContext implements SearchContext {

    private String customerId;
    private String contractId;

    public InvoiceSearchContext(final String contractId, final String customerId) {

        this.contractId = contractId;
        this.customerId = customerId;
    }

    public String getContractId() {

        return contractId;
    }

    public String getCustomerId() {

        return customerId;
    }
}
