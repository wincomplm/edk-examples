/*
 * Copyright (c) 2021 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.ui.impl.ui.methods;

import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexMethod;
import com.wincomplm.wex.security.commons.impl.WexSecurePage;

/**
 * An example to demonstrate how to use a wex method in a UI

 * @author simon
 */

@WexComponent(uid = "methods", description = "Wex Security Methods")
public class ExampleUIMethods {

    @WexMethod(name = "securePage", description = "A simple security example")
    public void securePage() throws Exception {
        WexSecurePage.secureAdminOnly();
    }//securePage

    
}
