/*
 * Copyright (c) 2021 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.config.methods;


import com.wincomplm.wex.config.auxs.helpers.WexConfigRegistryHelper;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.example.config.impl.config.ExampleConfiguration;
import com.wincomplm.wex.kernel.impl.annotations.WexMethod;

/**
 * @author simon
 */

@WexComponent(uid = "methods", description = "Wex Diagnostic Methods")
public class ExampleMethods {
    
    public static ExampleConfiguration config = (ExampleConfiguration) WexConfigRegistryHelper.instance.getConfig();

    @WexMethod(name = "test", description = "Display configuration")
    public String test() throws Exception {
        // This is test code but generally rendering HTML server side is not a good practice ;-)
        final String EOL = "<br>";
        String result = "";
        result += "Example String: " + config.getExampleString() + EOL;
        result += "Example Boolean: " + config.isExampleBoolean()+ EOL;
        result += "Example List: " + config.getExampleList()+ EOL;
        result += "Example Map: " + config.getExampleMap()+ EOL;
        result += "Example State List: " + config.getExampleStateList()+ EOL;
        return result;
    }//string

}
