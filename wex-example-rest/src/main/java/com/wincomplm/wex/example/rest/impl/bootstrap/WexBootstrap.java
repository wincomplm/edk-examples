
package com.wincomplm.wex.example.rest.impl.bootstrap;

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
        WexScanner.scan(wex, "com.wincomplm.wex.example.rest");
    }

    @Override
    public void terminate(IWexKernelPackage wex) throws Exception {
    }

}
