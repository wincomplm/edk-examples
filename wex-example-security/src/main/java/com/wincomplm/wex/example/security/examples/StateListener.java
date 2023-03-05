/*
 * Copyright (c) 2021 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.sast.examples;

import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexWtEventKey;
import com.wincomplm.wex.kernel.impl.annotations.WexWtListener;
import com.wincomplm.wex.kernel.impl.wki.IWexWtListener;
import wt.events.KeyedEvent;
import wt.lifecycle.LifeCycleServiceEvent;
import wt.part.WTPart;

/**
 * A simple listener
 * @author simon
 */
@WexComponent(uid = "wex-example-listener", description = "Example Set State Listener")
@WexWtListener({
@WexWtEventKey(eventClass = LifeCycleServiceEvent.class, keys = LifeCycleServiceEvent.SET_STATE, supported = {WTPart.class}, fatal = false)})
public class StateListener implements IWexWtListener<Object> {
 
    @Override
    public void onEvent(KeyedEvent event, String key, Object target) throws Exception {
        WTPart part = (WTPart) target;
    
    }
    
    
        
}
