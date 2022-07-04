/*
 * Copyright (c) 2021 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.log.methods;

import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexMethod;
import com.wincomplm.wex.log.base.api.IWexLogger;
import com.wincomplm.wex.log.base.api.WexLoggerFactory;
/**
 * A few example to demonstrate how create a log

 * A test page is here ptc1/com/wincomplm/wex/example/log/test
 * 
 * @author simon
 */

@WexComponent(uid = "methods", description = "Wex Diagnostic Methods")
public class ExampleMethods {
    
    // This gets the logger for this ex
    final IWexLogger logger = WexLoggerFactory.getLogger(getClass());
    
    @WexMethod(name = "createLog", description = "A simple log test")
    public void example() throws Exception {
        System.out.println("This will appear in the MS log (Not recommended)");
       
        String anObjectWithToString="My object";
        logger.error("Will always appear, for serious errors {0}", anObjectWithToString);
        logger.warn("Something we want to know about {0}", anObjectWithToString);

        logger.info("Used to give information on data {0}", anObjectWithToString);
        
        // Debug and trace only appear if the extension logging is enabled in the manager
        logger.debug("Used to give information on executiom {0}", anObjectWithToString);
        exampleTrace("An argument");
    }//createLog

    /*
        Note we should have good decomposition meaning very limited info tracing
        and entry and exit tracing should be enough to track error
     
        We sometimes do not add trace code to any methods in high iteration loop to avoid 
        filling logs and making the log analysis harder.
    
    */
    private String exampleTrace(String arg) {
        logger.trace("=>exampleTrace {0}",arg);
        String result = "Done!";
        logger.trace("<=exampleTrace {0}",result);
        return result;
    }
    
}
