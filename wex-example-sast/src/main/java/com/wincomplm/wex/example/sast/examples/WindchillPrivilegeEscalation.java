/*
 * Copyright (c) 2022 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */

package com.wincomplm.wex.example.sast.examples;

import wt.fc.Persistable;
import wt.fc.PersistenceServerHelper;
import wt.session.SessionHelper;
import wt.session.SessionServerHelper;

/**
 *
 * @author SimonHeath
 */
public class WindchillPrivilegeEscalation {

    static void accessPoM() throws Exception {
        Persistable p=null;
        PersistenceServerHelper.manager.insert(p);
    }
    
    static void accessEnforced() throws Exception  { 
        SessionServerHelper.manager.setAccessEnforced(true);
    }
    
    static void setAdmin() throws Exception  { 
        SessionHelper.manager.setAdministrator();
    }
}
