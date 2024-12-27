/*
 * Copyright (c) 2019 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.config.handlers;

import com.wincomplm.wex.config.impl.handlers.IValueSetHandler;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import wt.lifecycle.State;
import wt.session.SessionHelper;

/**
 *
 * @author Vlad-Tudor Marchis <vmarchis@wincom-plm.com>
 */
public class LifeCycleStateHandler implements IValueSetHandler<String> {

    @Override
    public Map<String, String> getValueSet(Locale locale) {
        State[] states = State.getStateSet();
        TreeMap<String, String> result = new TreeMap();
        for (State state : states) {
            try {
                result.put(state.toString(), state.getDisplay(SessionHelper.getLocale()));
            } catch (Exception e) {
                result.put(state.toString(), state.getDisplay());
            }
        }
        return result;
    }

    @Override
    public String toString(String o) {
        return o.toString();
    }

}
