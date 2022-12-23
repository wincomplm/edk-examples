/*
 * Copyright (c) 2022 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */

package com.wincomplm.wex.example.method.methods;

import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.wki.IWexCommandLine;
import java.io.Serializable;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import wt.method.RemoteAccess;

/**
 *
 * @author SimonHeath
 */
@WexComponent(uid = "wex-example-testcmd", description = "An example command line")
public class SimpleCommand implements Serializable, RemoteAccess, IWexCommandLine {
    
    @Option(name = "-msg", usage = "A message", required = true)
    public String msg;
    
    public void execute() {
        
        //Code here
        if (msg != null) {
            System.out.println("Hello world " + msg);
        }
    }
    
    @Override
    public int execute(String[] args) throws Exception {
        SimpleCommand instance = new SimpleCommand();
        CmdLineParser parser = new CmdLineParser(instance);
        parser.parseArgument(args);
        instance.execute();
        return 0;
    }
}
