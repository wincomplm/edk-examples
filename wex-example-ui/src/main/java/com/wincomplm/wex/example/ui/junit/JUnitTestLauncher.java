/*
 * Copyright (c) 2022 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */

package com.wincomplm.wex.example.ui.junit;


import com.wincomplm.wex.kernel.api.invoke.WexInvoker;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexMethod;
import com.wincomplm.wex.servlet.support.WexServletRequestWrapper;
import com.wincomplm.wex.servlet.support.WexServletResponseWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SimonHeath
 */
@WexComponent(uid = "test-methods", description = "Test Methods")
public class JUnitTestLauncher {
    
    @WexMethod(name = "run", description = "Run junit tests")
    public void run(HttpServletRequest httprequest, HttpServletResponse httpresponse) throws Exception {
        
        WexServletRequestWrapper wRequest = new WexServletRequestWrapper(httprequest);
        WexServletResponseWrapper wResponse = new WexServletResponseWrapper(httpresponse);
        
        WexInvoker.invoke("com.wincomplm.wex-junit","junit-methods.runTest",wRequest, wResponse,MainUiTest.class);
    }

}
