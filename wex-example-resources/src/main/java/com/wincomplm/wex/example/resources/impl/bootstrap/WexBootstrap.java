/*
 * Copyright (c) 2021 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.resources.impl.bootstrap;

import com.wincomplm.wex.kernel.impl.bootstrap.IWexBootstrap;
import com.wincomplm.wex.kernel.impl.manager.IWexKernelPackage;
import com.wincomplm.wex.loadconfig.impl.actions.ResourceAction;
import com.wincomplm.wex.loadconfig.impl.helper.InstallHelper;
import com.wincomplm.wex.system.impl.scan.WexScanner;
import java.io.File;
import org.apache.commons.io.FileUtils;


/**
 *
 * @author Nassim Bouayad-Agha
 */
public class WexBootstrap implements IWexBootstrap {

    @Override
    public void initialize(IWexKernelPackage wex) throws Exception {
        WexScanner.scan(wex, "com.wincomplm.wex.example.resources");
        
        InstallHelper.setWexid(wex.getUid());
        InstallHelper.setVersion("1.0");
        
        try {
            System.out.println("Is deploy:" + InstallHelper.isDeploy());
            if (InstallHelper.isDeploy()) {
                new ResourceAction().run(); 
            }      
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to init " + wex.getUid());
        }           
    }   

    @Override
    public void terminate(IWexKernelPackage wex) throws Exception {
        if (InstallHelper.isUndeploy()) {
            File lockPath = new File(InstallHelper.getLockPath());
            FileUtils.deleteDirectory(lockPath);
        }
    }

}
