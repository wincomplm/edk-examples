/*
 * Copyright (c) 2021 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.method.methods;

import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexMethod;
import wt.session.SessionHelper;

/**
 * A few example to demonstrate how to declare a wex method
 * These can be invoked from Windchill or other extension using the following calls
 * 
 * WexInvoker.invoke([wexid], [uid].[method-name], args);
 * 
 * e.g. 
 * WexInvoker.invoke("com.wincomplm.wex-example-method", "methods.example");
 * 
 * A test page is here ptc1/com/wincomplm/wex/example/method/test
 * 
 * @author simon
 */

@WexComponent(uid = "methods", description = "Wex Diagnostic Methods")
public class ExampleMethods {

    @WexMethod(name = "example", description = "A simple method example")
    public String example() throws Exception {
        return "Hello there!";
    }//exampleMethod
    
    @WexMethod(name = "argName", description = "A simple method example")
    public String argName(String name) throws Exception {
        return "Hello " + name + "!";
    }//exampleMethod

    @WexMethod(name = "userName", description = "A simple method example")
    public String userName() throws Exception {
        return SessionHelper.getPrincipal().getName();
    }//exampleMethod
    
}
