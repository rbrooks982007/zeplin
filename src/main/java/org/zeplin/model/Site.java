package org.zeplin.model;

/**
 * Created by rbrooks3 on 6/19/16.
 */
public class Site {

    private String siteName;
    private Address siteAddress;

    public String getSiteName() {

        return siteName;
    }

    public void setSiteName(final String siteName) {

        this.siteName = siteName;
    }

    public Address getSiteAddress() {

        return siteAddress;
    }

    public void setSiteAddress(final Address siteAddress) {

        this.siteAddress = siteAddress;
    }
}
