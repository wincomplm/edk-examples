/*
 * Copyright (c) 2019 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.tree.impl.ui.model;

import com.ptc.netmarkets.model.NmObject;
import com.ptc.netmarkets.model.NmOid;
import com.ptc.netmarkets.model.NmSimpleOid;
import com.wincomplm.wex.log.api.WexLogger;
import com.wincomplm.wex.log.base.api.IWexLogger;
import wt.util.HTMLEncoder;

/**
 *
 * @author Simon Heath
 */
public class WexTreeRow extends NmObject {

    static IWexLogger logger = WexLogger.getLogger(WexTreeRow.class);

    NmOid oid = null;

            
    public static WexTreeRow newWexTreeRow(String data) {
        WexTreeRow row = new WexTreeRow();
        row.data=data;
        row.oid = getNmOid(data);
        return row;
    }
    
    public String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public static NmOid getNmOid(String str) {
        NmSimpleOid oid = new NmSimpleOid();
        str = HTMLEncoder.encodeForHTMLContent(str);
        oid.setInternalName(str);
        return oid;
    }

    public NmOid getOid() {
        return oid;
    }
    
    

}
