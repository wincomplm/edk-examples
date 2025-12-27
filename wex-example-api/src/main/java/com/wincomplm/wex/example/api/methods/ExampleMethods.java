/*
 * Copyright (c) 2021 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.api.methods;

import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexMethod;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple APIs that can be called by other extensions e.g. Reporting
 * 
 * @author simon
 */

@WexComponent(uid = "methods", description = "Wex API Methods")
public class ExampleMethods {

    @WexMethod(name = "table-values", description = "A simple table example")
    public List<List<String>> tableValues() throws Exception {
        List<List<String>> result = new ArrayList();
        List<String> row1 = new ArrayList();
        row1.add("12345");
        row1.add("ACME");
        row1.add("Bolt");
        List<String> row2 = new ArrayList();
        row2.add("123456");
        row2.add("ACME");
        row2.add("Screw");        
        List<String> row3 = new ArrayList();
        row3.add("12347");
        row3.add("ACME");
        row3.add("Rocket");
        result.add(row1);
        result.add(row2);
        result.add(row3);
        return result;
    }//exampleMethod
    
    @WexMethod(name = "single-value", description = "A simple single value example")
    public String singleValue(String param) throws Exception {
        return param;
    }//exampleMethod

    
}
