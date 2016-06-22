package org.zeplin.model.contracts;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.zeplin.model.Order;

import java.util.List;

/**
 * Created by rbrooks3 on 6/20/16.
 */
public class Service extends Contract {


    private String id;
    private String name;
    private String site;
    private List<Order> orders;
    @DBRef
    private ServiceAgreement serviceAgreement;

    public String getId() {

        return id;
    }

    public void setId(final String id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(final String name) {

        this.name = name;
    }

    public ServiceAgreement getServiceAgreement() {

        return serviceAgreement;
    }

    public void setServiceAgreement(final ServiceAgreement serviceAgreement) {

        this.serviceAgreement = serviceAgreement;
    }

    public String getSite() {

        return site;
    }

    public void setSite(final String site) {

        this.site = site;
    }

    public List<Order> getOrders() {

        return orders;
    }

    public void setOrders(final List<Order> orders) {

        this.orders = orders;
    }

    @Override public Type getType() {
        return Type.SERVICE;
    }
}
