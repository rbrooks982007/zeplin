package org.zeplin.repository.impl;

import com.google.common.base.Optional;
import org.zeplin.model.Invoice;
import org.zeplin.repository.CrudCacheRepository;
import org.zeplin.repository.SearchRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutionException;

/**
 * Created by rbrooks3 on 6/21/16.
 */
public class InvoiceRepositoryImpl extends CrudCacheRepository<Invoice>
        implements SearchRepository<Invoice, InvoiceSearchContext> {

    private static final WeakHashMap<String, Invoice> backingCache = new WeakHashMap<String, Invoice>();

    public InvoiceRepositoryImpl() {

        Invoice invoice = new Invoice();
        invoice.setId(UUID.randomUUID().toString());
        invoice.setContractId("#WT-239");
        invoice.setCustomerId("Geico-WXCD");
        invoice.setDueDate(Calendar.getInstance().getTime());
        invoice.setStatus(Invoice.InvoiceStatus.PAST_DUE);
        invoice.setBalance(BigDecimal.valueOf(275.00));
        backingCache.put(invoice.getId(), invoice);

        invoice = new Invoice();
        invoice.setId(UUID.randomUUID().toString());
        invoice.setContractId("#WT-239");
        invoice.setCustomerId("Geico-WXCD");
        invoice.setDueDate(Calendar.getInstance().getTime());
        invoice.setStatus(Invoice.InvoiceStatus.PAID);
        invoice.setBalance(BigDecimal.valueOf(275.00));
        backingCache.put(invoice.getId(), invoice);

        invoice = new Invoice();
        invoice.setId(UUID.randomUUID().toString());
        invoice.setContractId("#HB-134");
        invoice.setCustomerId("Geico-WXCD");
        invoice.setDueDate(Calendar.getInstance().getTime());
        invoice.setStatus(Invoice.InvoiceStatus.DUE_SOON);
        invoice.setBalance(BigDecimal.valueOf(51550.00));
        backingCache.put(invoice.getId(), invoice);

        invoice = new Invoice();
        invoice.setId(UUID.randomUUID().toString());
        invoice.setContractId("#HB-134");
        invoice.setCustomerId("Geico-WXCD");
        invoice.setDueDate(Calendar.getInstance().getTime());
        invoice.setStatus(Invoice.InvoiceStatus.PAID);
        invoice.setBalance(BigDecimal.valueOf(51550.00));
        backingCache.put(invoice.getId(), invoice);

    }

    @Override public WeakHashMap<String, Invoice> getBackingCache() {

        return backingCache;
    }


    public List<Invoice> search(final InvoiceSearchContext searchContext) {

        List<Invoice> results = new ArrayList<Invoice>();

        try {
            if (searchContext.getCustomerId() != null) {
                for (Optional<Invoice> invoice : cache.getAll(getBackingCache().keySet()).values()) {
                    if (searchContext.getCustomerId().equals(invoice.get().getCustomerId())) {
                        results.add(invoice.get());
                    }
                }
            }

            if (searchContext.getContractId() != null && results.isEmpty()) {
                for (Optional<Invoice> invoice : cache.getAll(getBackingCache().keySet()).values()) {
                    if (searchContext.getContractId().equals(invoice.get().getContractId())) {
                        results.add(invoice.get());
                    }
                }
            } else if(searchContext.getContractId() != null) {
                List<Invoice> tmp = new ArrayList();
                for (Invoice invoice : results) {
                    if (searchContext.getContractId().equals(invoice.getContractId())) {
                        tmp.add(invoice);
                    }
                }

                results = tmp;
            }
        } catch (ExecutionException ex) {
            results = null;
        }
        return results;
    }
}
