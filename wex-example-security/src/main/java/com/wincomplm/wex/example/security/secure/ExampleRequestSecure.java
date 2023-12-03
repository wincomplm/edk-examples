/*
 * Copyright (c) 2023 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */

package com.wincomplm.wex.example.security.secure;

import com.wincomplm.wex.kernel.impl.annotations.WexMethod;
import com.wincomplm.wex.security.commons.impl.SecureRequestWrapper;
import com.wincomplm.wex.security.commons.impl.WexSanitizer;
import com.wincomplm.wex.security.commons.impl.WexSecurePage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SimonHeath
 */
public class ExampleRequestSecure {
    
    @WexMethod(name = "get-feature-data", description = "Get features")
    public void getFeatureData(HttpServletRequest httprequestUnsafe, HttpServletResponse httpresponse) throws Exception { 
        WexSecurePage.secureAdminOnly();
        SecureRequestWrapper httprequest = new SecureRequestWrapper(httprequestUnsafe);
        // No XSS can be passed in
        String fid = httprequest.getSecureParameter("id");
        // No XSS can be sent out
        String safeOutput = WexSanitizer.sanitize("javascript could be here");
        // This will be picked up by WVE-2023-0506
        httpresponse.getOutputStream().print(safeOutput);
    }//getFeatures
    
}
