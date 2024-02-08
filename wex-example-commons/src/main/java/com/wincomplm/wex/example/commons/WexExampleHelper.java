/*
 * Copyright (c) 2023 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */

package com.wincomplm.wex.example.commons;

/**
 *
 * @author SimonHeath
 */
public class WexExampleHelper {

    public static WexExampleHelper instance = new WexExampleHelper();
    
    public String getVersion() {
        return "1.0";
    }
    
}
