package org.zeplin.repository.impl;

import com.google.common.base.Optional;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.zeplin.model.Order;
import org.zeplin.model.contracts.Customer;
import org.zeplin.model.contracts.Service;
import org.zeplin.model.contracts.ServiceAgreement;
import org.zeplin.repository.CrudCacheRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;

/**
 * Created by rbrooks3 on 6/21/16.
 */
@Component
@Scope("application")
public class CustomerRepositoryImpl extends CrudCacheRepository<Customer> {

    private static final WeakHashMap<String, Customer> backingCache = new WeakHashMap<String, Customer>();

    public CustomerRepositoryImpl() {

        ServiceAgreement agreement = new ServiceAgreement();
        agreement.setContractId("#SA-432");
        agreement.setId(UUID.randomUUID().toString());
        agreement.setMaxHours(160);
        agreement.setCost(BigDecimal.valueOf(125.00));
        agreement.setProjectSummary("This SOW covers the discovery and documentation of ABC Health Corporation’s (ABCHC)" +
                                    " wired and wireless local area networks (LANs).");
        agreement.setScopeOfWork("Document and evaluate IP Address allocation and usage\n" +
                                 "Document physical layout of all LANs");
        agreement.setCost(BigDecimal.valueOf(125.00));
        List<Order> orders = new ArrayList<Order>();
        Order order  = new Order();
        order.setDescription("Configuration and Testing of Equipment");
        order.setOrderType(Order.OrderType.NON_RECURRING);
        order.setPrice(BigDecimal.valueOf(3485.00));
        orders.add(order);
        order.setDescription("Remote Site VPN");
        order.setOrderType(Order.OrderType.RECURRING);
        order.setPrice(BigDecimal.valueOf(275.00));
        orders.add(order);

        //Service 1
        Service service = new Service();
        service.setId(UUID.randomUUID().toString());
        service.setOrders(orders);
        service.setSite("Site 1");
        service.setName("100 Mbps MPLS");
        service.setContractId("#WT-239");
        service.setServiceAgreement(agreement);
        service.setCost(BigDecimal.valueOf(3760.00));

        //Service 2
        service = new Service();
        service.setId(UUID.randomUUID().toString());
        service.setOrders(Collections.singletonList(order));
        service.setSite("Site 2");
        service.setName("100 Mbps MPLS");
        service.setContractId("#WT-239");
        service.setServiceAgreement(agreement);
        service.setCost(BigDecimal.valueOf(275.00));

        Customer customer = new Customer();
        customer.setId(UUID.randomUUID().toString());
        customer.setServices(Collections.singletonList(service));
        customer.setContractId("#HB-134");

        customer.setCost(BigDecimal.valueOf(4035.00));
        backingCache.put(customer.getId(), customer);
        for(Map.Entry<String, Customer> entry: backingCache.entrySet()) {
            cache.put(entry.getKey(), Optional.fromNullable(entry.getValue()));
        }

    }

    @Override public WeakHashMap<String, Customer> getBackingCache() {

        return backingCache;
    }
}
