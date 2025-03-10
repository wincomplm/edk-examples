/*
 * Copyright (c) 2023 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */

package com.wincomplm.wex.example.security.secure;

import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexMethod;
import com.wincomplm.wex.security.commons.impl.WexPerUserRateLimiter;
import com.wincomplm.wex.security.commons.impl.WexSecureRequestWrapper;
import com.wincomplm.wex.security.commons.impl.WexSanitizer;
import com.wincomplm.wex.security.commons.impl.WexSecurePage;
import com.wincomplm.wex.security.commons.impl.access.WexAdminCheckAccess;
import com.wincomplm.wex.wt.framework.commons.system.WTConstants;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SimonHeath
 */
@WexComponent(uid = "methods", description = "Wex Security Methods")
public class ExampleRequestSecure {
    
    static WexPerUserRateLimiter limiter = WexPerUserRateLimiter.newPerUserRateLimiter(10, TimeUnit.MILLISECONDS.convert(10, TimeUnit.MINUTES));

    @WexMethod(name = "get-example-data", description = "Get example")
    public void getExampleData(HttpServletRequest httprequestUnsafe, HttpServletResponse httpresponse) throws Exception { 
        
        if (!WexAdminCheckAccess.instance.isSiteOrBusinessAdmin()) {
            httpresponse.sendError(403, "User is not an administrator.");
        }       
        limiter.checkException();

        WexSecureRequestWrapper httprequest = new WexSecureRequestWrapper(httprequestUnsafe);
        // No XSS can be passed in
        String fid = httprequest.getSecureParameter("id");
        // No XSS can be sent out
        String safeOutput = WexSanitizer.sanitize("javascript <img src=1 onerror=alert('xss')> could be here, or a path " + WTConstants.WTHOME); 
        httpresponse.getOutputStream().print(safeOutput);
    }//getExampleData
    
    
    @WexMethod(name = "securePage", description = "A simple security example")
    public void securePage(HttpServletRequest httprequestUnsafe, HttpServletResponse httpresponse) throws Exception {
        WexSecurePage.secureSiteAdminOnly();
    }//securePage
    
}
