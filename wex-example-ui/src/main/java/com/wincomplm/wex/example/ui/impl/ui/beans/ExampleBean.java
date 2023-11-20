/*
 * Copyright (c) 2023 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.ui.impl.ui.beans;

import com.wincomplm.wex.kernel.impl.annotations.WexClass;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import org.owasp.html.Sanitizers;
import wt.util.WTException;

/**
 *
 * @author Simon
 */
@WexComponent(uid = "example-bean", description = "Bean for methods")
@WexClass
public class ExampleBean {
    
   public String getTestParam() throws WTException {
        String data = "Some example data";
        data = Sanitizers.FORMATTING.sanitize(data);
        return data;
    }//getTestParam
    
}
