/*
 * Copyright (c) 2021 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.ui.resources;

import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import wt.util.resource.RBEntry;
import wt.util.resource.RBNameException;
import wt.util.resource.RBUUID;
import wt.util.resource.WTListResourceBundle;

@WexComponent(uid = "com.wincomplm.wex.example.ui.resources.WexResources", description = "Resource bundle")
@RBUUID("com.wincomplm.wex.example.ui.resources.WexResources")
@RBNameException
public class WexResources extends WTListResourceBundle {

    @RBEntry("Example Menu")
    public static final String P1 = "com.wincomplm.wex.example.ui.edkHelloWorld.description";
    @RBEntry("Example Menu")
    public static final String P2 = "com.wincomplm.wex.example.ui.edkHelloWorld.tooltip";
    @RBEntry("Example Menu")
    public static final String P3 = "com.wincomplm.wex.example.ui.edkHelloWorld.activetooltip";
    
    @RBEntry("Example Quick Menu")
    public static final String P4 = "com.wincomplm.wex.example.ui.edkHelloWorldNonPop.description";
    @RBEntry("Example Quick Menu")
    public static final String P5 = "com.wincomplm.wex.example.ui.edkHelloWorldNonPop.tooltip";
    @RBEntry("Example Quick Menu")
    public static final String P6 = "com.wincomplm.wex.example.ui.edkHelloWorldNonPop.activetooltip";

    @RBEntry("Example Command Menu")
    public static final String P7 = "com.wincomplm.wex.example.ui.action-methods.example-command.description";
    @RBEntry("Example Command Menu")
    public static final String P8 = "com.wincomplm.wex.example.ui.action-methods.example-command.tooltip";
    @RBEntry("Example Command Menu")
    public static final String P9 = "com.wincomplm.wex.example.ui.action-methods.example-command.activetooltip";
    
    @RBEntry("Example Manager")
    public static final String PU4 = "com.wincomplm.wex.example.ui.exampleManager.description";
    @RBEntry("Example Manager")
    public static final String PU5 = "com.wincomplm.wex.example.ui.exampleManager.tooltip";
    @RBEntry("Example Manager")
    public static final String PU6 = "com.wincomplm.wex.example.ui.exampleManager.activetooltip";
    
    
}
