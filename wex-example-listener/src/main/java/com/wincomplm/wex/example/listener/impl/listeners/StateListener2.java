/*
 * Copyright (c) 2021 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.wincomplm.wex.example.listener.impl.listeners;

import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexWtEventKey;
import com.wincomplm.wex.kernel.impl.annotations.WexWtListener;
import com.wincomplm.wex.kernel.impl.wki.IWexWtListener;
import com.wincomplm.wex.log.api.WexLogger;
import com.wincomplm.wex.log.base.api.IWexLogger;
import wt.events.KeyedEvent;
import wt.lifecycle.LifeCycleServiceEvent;
import wt.part.WTPart;

/**
 * A simple listener
 * @author simon
 */
@WexComponent(uid = "wex-example-listener2", description = "Example Set State Listener")
@WexWtListener({
@WexWtEventKey(eventClass = LifeCycleServiceEvent.class, keys = LifeCycleServiceEvent.SET_STATE, supported = {WTPart.class}, fatal = false)})
public class StateListener2 implements IWexWtListener<Object> {
 
    private IWexLogger logger = WexLogger.getLogger(this.getClass());

    @Override
    public void onEvent(KeyedEvent event, String key, Object target) throws Exception {
        WTPart part = (WTPart) target;
        
        // Use a warning logger (which always logs) to print the number of the part 
        logger.warn("[L2] A part has changed state {0} to {1}",part.getNumber(),part.getState().toString());
    
    }
    
    
        
}
