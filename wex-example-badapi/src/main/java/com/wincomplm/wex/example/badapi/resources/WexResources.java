/*
 * Copyright (c) 2021 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.badapi.resources;

import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import wt.util.resource.RBEntry;
import wt.util.resource.RBNameException;
import wt.util.resource.RBUUID;
import wt.util.resource.WTListResourceBundle;

@WexComponent(uid = "com.wincomplm.wex.example.badapi.resources.WexResources", description = "Resource bundle")
@RBUUID("com.wincomplm.wex.example.badapi.resources.WexResources")
@RBNameException
public class WexResources extends WTListResourceBundle {

    /*
        @RBEntry("Example")
        public static final String P0 = "com.wincomplm.wex.example.badapi.[your-action-name].description";
        @RBEntry("Example")
        public static final String P1 = "com.wincomplm.wex.example.badapi.[your-action-name].tooltip";
        @RBEntry("Example")
        public static final String p3 = "com.wincomplm.wex.example.badapi.[your-action-name].activetooltip";
    */

}
