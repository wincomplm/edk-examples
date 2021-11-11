/*
 *  Copyright (c) 2020 Wincom Consulting S.L.
 *  All Rights Reserved.
 *  This source is subject to the terms of a software license agreement.
 *  You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.part.naming.nikosp.impl.config;

import com.wincomplm.wex.config.impl.annotations.ConfigOption;
import com.wincomplm.wex.config.impl.exceptions.WexValidationException;
import com.wincomplm.wex.config.impl.handlers.LifeCycleStateHandler;
import com.wincomplm.wex.config.impl.ifc.IWexConfiguration;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.OptionalDataException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nikolaos Papadakis (npapadakis@wincom-plm.com)
 */
@WexComponent(uid = "part-naming-nikosp-config", description = "Example configuration")
public class PartNamingNikosPConfig implements IWexConfiguration<PartNamingNikosPConfig>, Externalizable, Serializable {

    public static final long serialVersionUID = 1L; // We need to not fail to serialize, worst case is a reset

    @ConfigOption(category = "Creation Options", description = "Creation folder", required = true, handler = ValidFolderHandler.class)
    String folder = "YourName";
    @ConfigOption(category = "Creation Options", description = "Creation container", required = true)
    String container = "Bootcamp";
    @ConfigOption(category = "Creation Options", description = "Part type", required = true)
    String type = "wt.part.WTPart";

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void assign(PartNamingNikosPConfig configuration) throws WexValidationException {
        // Can add code here to adjust assignment
        // for example cross ref the system
    }

    @Override
    public void validate() throws WexValidationException {
        // We ccheck the consistency of the data here
    }

    // These methods must repeat the order
    // Never take anything away otherwise we break serialization we hide values no longer needed
    // We add new items at the end 
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(folder);
    }//writeExternal

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        try {
            this.folder = (String) in.readObject();

        } catch (OptionalDataException ode) {
            System.out.println("Failed to process config [OK] if post install");
        }
    }//readExternal

}
