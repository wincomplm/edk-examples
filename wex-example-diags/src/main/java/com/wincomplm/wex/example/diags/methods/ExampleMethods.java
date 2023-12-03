/*
 * Copyright (c) 2021 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.diags.methods;


import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexMethod;
import com.wincomplm.wex.security.commons.impl.SecureRequestWrapper;
import com.wincomplm.wex.security.commons.impl.WexSanitizer;
import com.wincomplm.wex.wt.framework.commons.persist.WexQueryHelper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wt.part.WTPart;

/**
 * @author simon
 */

@WexComponent(uid = "methods", description = "Wex Diagnostic Methods")
public class ExampleMethods {
    
    @WexMethod(name = "test", description = "Display configuration")
    public String test(HttpServletRequest requestUnsafe, HttpServletResponse response) throws Exception {
        SecureRequestWrapper request = new SecureRequestWrapper(requestUnsafe);  
        String oid = request.getSecureParameter("oid");
        WTPart part = (WTPart) WexQueryHelper.getObject(oid);
        return WexSanitizer.sanitize("Number: " + part.getNumber());
    }//test

}
