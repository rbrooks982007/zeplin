package org.zeplin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by rbrooks3 on 6/20/16.
 */
@Document
public class Invoice implements Identity {

    public enum InvoiceStatus {
        DUE_SOON,
        PAID,
        PAST_DUE,
    }

    @Id
    private String id;
    private BigDecimal balance;
    private String customerId;
    private String contractId;
    private Date dueDate;
    private Date resolvedDate;
    private InvoiceStatus status;


    public String getId() {

        return id;
    }

    public void setId(final String id) {

        this.id = id;
    }

    public BigDecimal getBalance() {

        return balance;
    }

    public void setBalance(final BigDecimal balance) {

        this.balance = balance;
    }

    public String getCustomerId() {

        return customerId;
    }

    public void setCustomerId(final String customerId) {

        this.customerId = customerId;
    }

    public String getContractId() {

        return contractId;
    }

    public void setContractId(final String contractId) {

        this.contractId = contractId;
    }

    public Date getDueDate() {

        return dueDate;
    }

    public void setDueDate(final Date dueDate) {

        this.dueDate = dueDate;
    }

    public Date getResolvedDate() {

        return resolvedDate;
    }

    public void setResolvedDate(final Date resolvedDate) {

        this.resolvedDate = resolvedDate;
    }

    public InvoiceStatus getStatus() {

        return status;
    }

    public void setStatus(final InvoiceStatus status) {

        this.status = status;
    }

    @Override public boolean equals(final Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Invoice invoice = (Invoice) o;

        return id.equals(invoice.id);

    }

    @Override public int hashCode() {

        return id.hashCode();
    }
}
