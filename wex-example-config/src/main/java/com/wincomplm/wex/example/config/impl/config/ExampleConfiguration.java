/*
 * Copyright (c) 2021 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
*/

package com.wincomplm.wex.example.config.impl.config;

import com.wincomplm.wex.config.auxs.handlers.LifeCycleStateHandler;
import com.wincomplm.wex.config.impl.annotations.ConfigOption;
import com.wincomplm.wex.config.impl.exceptions.WexValidationException;
import com.wincomplm.wex.config.impl.ifc.IWexConfiguration;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.security.commons.impl.WexSanitizer;
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
 * An example configuration
 * @author Simon
 */
@WexComponent(uid = "example-config", description = "Example configuration")
public class ExampleConfiguration implements IWexConfiguration<ExampleConfiguration>,Externalizable, Serializable {

    public static final long serialVersionUID = 1L; // We need to not fail to serialize, worst case is a reset

    @ConfigOption(category = "Basic", description = "Simple string", required = false)
    String exampleString = "bad";

    @ConfigOption(category = "Basic", description = "Boolean",
            longdesc = "A true/false boolean", required = false)
    boolean exampleBoolean = false;

    
    @ConfigOption(category = "Collections", description = "String list",
            longdesc = "A string list", required = false)
    List<String> exampleList = new ArrayList();
    
    @ConfigOption(category = "Collections", description = "String map",
            longdesc = "A string map", required = false)
    Map<String,String> exampleMap = new HashMap();
    
    @ConfigOption(category = "Collections", description = "String list with handler",
            longdesc = "String list with handler", required = false, handler = LifeCycleStateHandler.class)
    List<String> exampleStateList = new ArrayList();

    @ConfigOption(category = "Security", description = "Password", required = false, hidden=true)
    String examplePassword = "";
        
    @ConfigOption(category = "Business Admin", description = "An option visible to the business admins", required = false, business=true)
    String businessString = "";
        
    public boolean isExampleBoolean() {
        return exampleBoolean;
    }

    public void setExampleBoolean(boolean exampleBoolean) {
        this.exampleBoolean = exampleBoolean;
    }

    public List<String> getExampleList() {
        return exampleList;
    }

    public void setExampleList(List<String> exampleList) {
        this.exampleList = exampleList;
    }

    public Map<String, String> getExampleMap() {
        return WexSanitizer.sanitize(exampleMap);
    }

    public void setExampleMap(Map<String, String> exampleMap) {
        this.exampleMap = exampleMap;
    }

    public List<String> getExampleStateList() {
        return (List<String>) WexSanitizer.sanitize(exampleStateList);
    }

    public void setExampleStateList(List<String> exampleStateList) {
        this.exampleStateList = exampleStateList;
    }

    public String getExampleString() {
        return WexSanitizer.sanitize(exampleString);
    }

    public void setExampleString(String exampleString) {
        this.exampleString = exampleString;
    }

    public String getExamplePassword() {
        return examplePassword;
    }

    public void setExamplePassword(String examplePassword) {
        this.examplePassword = examplePassword;
    }

    public String getBusinessString() {
        return businessString;
    }

    public void setBusinessString(String businessString) {
        this.businessString = businessString;
    }

    
    public void assign(ExampleConfiguration configuration) throws WexValidationException {
        // Can add code here to adjust assignment
        // for example cross ref the system
        System.out.println("Hello");
    }
        
    @Override
    public void validate() throws WexValidationException {
        // We ccheck the consistency of the data here
        if (exampleString.equals("bad")) {
            throw new WexValidationException("exampleString","Please change to something that is not bad!");
        }
    }
    
    // These methods must repeat the order
    // Never take anything away otherwise we break serialization we hide values no longer needed
    // We add new items at the end 
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(WexSanitizer.sanitize(exampleString));
        out.writeObject(exampleBoolean);
        out.writeObject(WexSanitizer.sanitize(exampleList));
        out.writeObject(WexSanitizer.sanitize(exampleMap));
        out.writeObject(exampleStateList);
        out.writeObject(WexSanitizer.sanitize(examplePassword));
        out.writeObject(businessString);
        
    }//writeExternal

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        try {
            this.exampleString = (String) in.readObject();      
            this.exampleBoolean = (Boolean) in.readObject();   
            this.exampleList = (List<String>) in.readObject();   
            this.exampleMap = (Map<String,String>) in.readObject();   
            this.exampleStateList = (List<String>) in.readObject();   
            this.examplePassword = (String) in.readObject();   
            this.businessString = (String) in.readObject();   
            
        } catch (OptionalDataException ode) {
            System.out.println("Failed to process config [OK] if post install");
        }
    }//readExternal


}
