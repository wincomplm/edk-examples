/*
 * Copyright (c) 2020 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
*/

package com.wincomplm.wex.example.config.impl.config;

import com.wincomplm.wex.config.impl.annotations.ConfigOption;
import com.wincomplm.wex.config.impl.exceptions.WexValidationException;
import com.wincomplm.wex.config.impl.ifc.IWexConfiguration;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.OptionalDataException;
import java.io.Serializable;

/**
 *
 * @author Nassim Bouayad-Agha
 */
@WexComponent(uid = "exa,`ñe-config", description = "Example configuration")
public class ExampleConfiguration implements Externalizable,IWexConfiguration<ExampleConfiguration>, Serializable {

    public static final long serialVersionUID = 1L;

    @ConfigOption(category = "String", description = "A simple string", required = false)
    String exampleString;


    public void assign(ExampleConfiguration configuration) throws WexValidationException {

    }
        
    @Override
    public void validate() throws WexValidationException {

    }

   @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(exampleString);
    }//writeExternal

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        try {
            this.exampleString = (String) in.readObject();      
        } catch (OptionalDataException ode) {
            System.out.println("Failed to process config wex-siliconexpert-sync [OK] if post install");
        }
    }//readExternal


}
