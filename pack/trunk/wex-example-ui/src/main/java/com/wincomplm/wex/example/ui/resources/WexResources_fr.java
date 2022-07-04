/*
 * Copyright (c) 2021 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.ui.resources;

import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexLanguage;
import com.wincomplm.wex.kernel.impl.annotations.WexLocale;
import wt.util.resource.RBEntry;
import wt.util.resource.RBNameException;
import wt.util.resource.RBUUID;
import wt.util.resource.WTListResourceBundle;

@WexComponent(uid = "com.wincomplm.wex.example.ui.resources.WexResources", description = "Resource bundle")
@RBUUID("com.wincomplm.wex.example.ui.resources.WexResources")
@WexLocale(WexLanguage.FRENCH)
@RBNameException
public class WexResources_fr extends WTListResourceBundle {

    @RBEntry("French Example Menu")
    public static final String P1 = "com.wincomplm.wex.example.ui.edkHelloWorld.description";
    @RBEntry("French Example Menu")
    public static final String P2 = "com.wincomplm.wex.example.ui.edkHelloWorld.tooltip";
    @RBEntry("French Example Menu")
    public static final String P3 = "com.wincomplm.wex.example.ui.edkHelloWorld.activetooltip";
    
    @RBEntry("French Quick Menu")
    public static final String P4 = "com.wincomplm.wex.example.ui.edkHelloWorldNonPop.description";
    @RBEntry("French Quick Menu")
    public static final String P5 = "com.wincomplm.wex.example.ui.edkHelloWorldNonPop.tooltip";
    @RBEntry("French Quick Menu")
    public static final String P6 = "com.wincomplm.wex.example.ui.edkHelloWorldNonPop.activetooltip";
}
