/*
 * Copyright (c) 2022 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.rest.impl.config;

import com.wincomplm.wex.config.impl.annotations.ConfigOption;
import com.wincomplm.wex.config.impl.exceptions.WexValidationException;
import com.wincomplm.wex.config.impl.ifc.IWexConfiguration;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

/**
 *
 * @author jluna@wincom-plm.com
 */
@WexComponent(uid = "rest-example-config", description = "Rest Config")
public class RestExampleConfig implements IWexConfiguration<RestExampleConfig>, Externalizable, Serializable {

    public static final long serialVersionUID = 1L;

    @ConfigOption(category = "Get data", description = "Gather parts modified from X days ago", required = false)
    String partsFromDaysAgo = "1";

    public String getPartsFromDaysAgo() {
        return partsFromDaysAgo;
    }

    public void setPartsFromDaysAgo(String partsFromDaysAgo) {
        this.partsFromDaysAgo = partsFromDaysAgo;
    }

    @Override
    public void assign(RestExampleConfig arg0) throws WexValidationException {

    }

    @Override
    public void validate() throws WexValidationException {

    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(partsFromDaysAgo);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.partsFromDaysAgo = (String) in.readObject();
    }

}
