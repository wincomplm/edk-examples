/*
 * Copyright (c) 2025 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */

package com.wincomplm.wex.example.sync.startup;


import com.wincomplm.wex.kernel.api.invoke.WexInvoker;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.manager.WexMethodServerWaiter.IWexMethodServerReadyListener;

/**
 *
 * @author Simon Heath
 */
@WexComponent(uid="Do sync",description="Do resource sync")
public class DoSyncResources implements IWexMethodServerReadyListener {

    @Override
    public void onMethodServerReady() throws Exception {
        try {
            System.out.println("Initiating resource sync");
            WexInvoker.invoke("com.wincomplm.wex-sync","methods.sync-resources");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("Failed to sync resources");
        }
    }


}
