/*
 * Copyright (c) 2020 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.part.naming.nikosp.impl.config;

import com.wincomplm.wex.config.impl.handlers.IValueSetHandler;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author simon
 */
public class ValidFolderHandler implements IValueSetHandler<String> {

    @Override
    public Map<String, String> getValueSet(Locale locale) {
        TreeMap<String, String> result = new TreeMap();
        result.put("NikosP", "NikosP");
        result.put("BadFolder", "BadFolder");
        return result;
    }

    @Override
    public String toString(String o) {
        return o;
    }
}
