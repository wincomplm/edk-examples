/*
 * Copyright (c) 2021 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.file.impl.bootstrap;

import com.wincomplm.wex.kernel.impl.bootstrap.IWexBootstrap;
import com.wincomplm.wex.kernel.impl.manager.IWexKernelPackage;
import com.wincomplm.wex.system.impl.scan.WexScanner;


/**
 *
 * @author Nassim Bouayad-Agha
 */
public class WexBootstrap implements IWexBootstrap {

    @Override
    public void initialize(IWexKernelPackage wex) throws Exception {
        WexScanner.scan(wex, "com.wincomplm.wex.example.file");
    }

    @Override
    public void terminate(IWexKernelPackage wex) throws Exception {
    }

}
