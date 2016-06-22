package org.zeplin.model.contracts;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by rbrooks3 on 6/19/16.
 */
public abstract class Contract {

    public static enum State {
        CLOSED,
        EXPIRING,
        NEW,
    }

    public static enum Type {
        SIMPLE,
        SERVICE,
        SERVICE_AGREEMENT
    }

    private BigDecimal cost;
    private String contractId;
    private Date end;
    private Date start;
    private int term;
    private State state;

    public abstract Type getType();

    public BigDecimal getCost() {

        return cost;
    }

    public void setCost(final BigDecimal cost) {

        this.cost = cost;
    }

    public int getTerm() {

        return term;
    }

    public void setTerm(final int term) {

        this.term = term;
    }

    public Date getStart() {

        return start;
    }

    public void setStart(final Date start) {

        this.start = start;
    }

    public Date getEnd() {

        return end;
    }

    public void setEnd(final Date end) {

        this.end = end;
    }

    public String getContractId() {

        return contractId;
    }

    public void setContractId(final String contractId) {

        this.contractId = contractId;
    }

    public State getState() {

        return state;
    }

    public void setState(final State state) {

        this.state = state;
    }
}
