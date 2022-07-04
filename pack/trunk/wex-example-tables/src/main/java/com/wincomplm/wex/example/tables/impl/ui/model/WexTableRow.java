/*
 * Copyright (c) 2019 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.tables.impl.ui.model;

import com.wincomplm.wex.log.api.WexLogger;
import com.wincomplm.wex.log.base.api.IWexLogger;

/**
 *
 * @author Simon Heath
 */
public class WexTableRow {

    static IWexLogger logger = WexLogger.getLogger(WexTableRow.class);

    
    public static WexTableRow newWexTableRow(String data) {
        WexTableRow row = new WexTableRow();
        row.data=data;
        return row;
    }
    
    public String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
        

}
