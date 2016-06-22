package org.zeplin.model.contracts;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.zeplin.model.Identity;
import java.util.List;

/**
 * Created by rbrooks3 on 6/20/16.
 */

@Document
public class Customer extends Contract implements Identity {

    @Id
    private String id;
    private List<Service> services;

    public String getId() {

        return id;
    }

    public void setId(final String id) {

        this.id = id;
    }

    public List<Service> getServices() {

        return services;
    }

    public void setServices(final List<Service> services) {

        this.services = services;
    }

    @Override public Type getType() {

        return Type.SIMPLE;
    }

    @Override public boolean equals(final Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Customer customer = (Customer) o;

        return id.equals(customer.id);

    }

    @Override public int hashCode() {

        return id.hashCode();
    }
}
