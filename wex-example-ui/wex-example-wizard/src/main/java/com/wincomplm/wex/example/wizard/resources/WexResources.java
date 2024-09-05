/*
 * Copyright (c) 2021 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.wizard.resources;

import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import wt.util.resource.RBEntry;
import wt.util.resource.RBNameException;
import wt.util.resource.RBUUID;
import wt.util.resource.WTListResourceBundle;

@WexComponent(uid = "com.wincomplm.wex.example.wizard.resources.WexResources", description = "Resource bundle")
@RBUUID("com.wincomplm.wex.example.wizard.resources.WexResources")
@RBNameException
public class WexResources extends WTListResourceBundle {

    @RBEntry("Wizard Example")
    public static final String P0 = "com.wincomplm.wex.example.wizard.edkWizard.description";
    @RBEntry("Wizard Example")
    public static final String P1 = "com.wincomplm.wex.example.wizard.edkWizard.tooltip";
    @RBEntry("Wizard Example")
    public static final String P2 = "com.wincomplm.wex.example.wizard.edkWizard.activetooltip";
    
    @RBEntry("Step 1")
    public static final String P3 = "com.wincomplm.wex.example.wizard.edkWizardStep1.description";
    @RBEntry("Step 1")
    public static final String P4 = "com.wincomplm.wex.example.wizard.edkWizardStep1.title";
    @RBEntry("Step 1")
    public static final String P5 = "com.wincomplm.wex.example.wizard.edkWizardStep1.tooltip";

    @RBEntry("Step 2")
    public static final String P6 = "com.wincomplm.wex.example.wizard.edkWizardStep2.description";
    @RBEntry("Step 2")
    public static final String P7 = "com.wincomplm.wex.example.wizard.edkWizardStep2.title";
    @RBEntry("Step 2")
    public static final String P8 = "com.wincomplm.wex.example.wizard.edkWizardStep2.tooltip";

}
