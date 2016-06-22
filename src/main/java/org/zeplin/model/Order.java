package org.zeplin.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by rbrooks3 on 6/19/16.
 */
public class Order {

    public static enum OrderType {
        NON_RECURRING,
        RECURRING
    }

    private String description;
    private Date date;
    private OrderType orderType;
    private BigDecimal price;

    public String getDescription() {

        return description;
    }

    public void setDescription(final String description) {

        this.description = description;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(final Date date) {

        this.date = date;
    }

    public OrderType getOrderType() {

        return orderType;
    }

    public void setOrderType(final OrderType orderType) {

        this.orderType = orderType;
    }

    public BigDecimal getPrice() {

        return price;
    }

    public void setPrice(final BigDecimal price) {

        this.price = price;
    }
}
