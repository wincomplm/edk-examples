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

    
    public static WexTableRow newWexTableRow(String name,String nickName) {
        WexTableRow row = new WexTableRow();
        row.name=name;
        row.nickName=nickName;
        return row;
    }
    
    public String name;
    public String nickName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
        

}
