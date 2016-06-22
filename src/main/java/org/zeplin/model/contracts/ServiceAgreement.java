package org.zeplin.model.contracts;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by rbrooks3 on 6/19/16.
 */
@Document
public class ServiceAgreement extends Contract {

    @Id
    private String id;
    private String projectSummary;
    private String scopeOfWork;
    private int maxHours;

    public String getId() {

        return id;
    }

    public void setId(final String id) {

        this.id = id;
    }

    public int getMaxHours() {

        return maxHours;
    }

    public void setMaxHours(final int maxHours) {

        this.maxHours = maxHours;
    }

    public String getProjectSummary() {

        return projectSummary;
    }

    public void setProjectSummary(final String projectSummary) {

        this.projectSummary = projectSummary;
    }

    public String getScopeOfWork() {

        return scopeOfWork;
    }

    public void setScopeOfWork(final String scopeOfWork) {

        this.scopeOfWork = scopeOfWork;
    }

    @Override public Type getType() {

        return Type.SERVICE_AGREEMENT;
    }
}
