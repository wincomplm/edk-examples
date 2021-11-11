/*
 *  Copyright (c) 2020 Wincom Consulting S.L.
 *  All Rights Reserved.
 *  This source is subject to the terms of a software license agreement.
 *  You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.part.naming.nikosp.resources;

import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import wt.util.resource.RBEntry;
import wt.util.resource.RBNameException;
import wt.util.resource.RBUUID;
import wt.util.resource.WTListResourceBundle;

/**
 *
 * @author Nikolaos Papadakis (npapadakis@wincom-plm.com)
 */
@WexComponent(uid = "com.wincomplm.wex.part.naming.nikosp.resources.WexResources", description = "Resource bundle")
@RBUUID("com.wincomplm.wex.part.naming.nikosp.resources.WexResources")
@RBNameException
public class WexResources extends WTListResourceBundle {

    @RBEntry("Part Naming NikosP")
    public static final String PRIVATE_CONSTANT_0 = "com.wincomplm.wex.part.naming.nikosp.wexPartNamingNikosP.description";
    @RBEntry("Part Naming NikosP")
    public static final String PRIVATE_CONSTANT_1 = "com.wincomplm.wex.part.naming.nikosp.wexPartNamingNikosP.tooltip";
    @RBEntry("Part Naming NikosP")
    public static final String PRIVATE_CONSTANT_2 = "com.wincomplm.wex.part.naming.nikosp.wexPartNamingNikosP.activetooltip";

}
