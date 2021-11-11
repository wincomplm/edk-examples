/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wincomplm.part.naming.nikosp.impl.bootstrap;

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
        WexScanner.scan(wex, "com.wincomplm.part.naming.nikosp");
    }

    @Override
    public void terminate(IWexKernelPackage wex) throws Exception {
    }

}
