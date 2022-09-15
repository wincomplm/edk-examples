/*
 * Copyright (c) 2019 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
*/

package com.wincomplm.wex.example.queues.impl.queue;

import com.wincomplm.wex.log.api.WexLogger;
import com.wincomplm.wex.log.base.api.IWexLogger;
import wt.org.WTPrincipal;
import wt.queue.ProcessingQueue;
import wt.queue.QueueHelper;
import wt.session.SessionHelper;
import wt.session.SessionServerHelper;
import wt.util.WTException;

/**
 *
 * @author simon
 */
public class WexProcessQueueHelper {
    

// --- Operation Section ---

    private static IWexLogger logger = WexLogger.getLogger(WexProcessQueueHelper.class);
    public static WexProcessQueueHelper instance = new WexProcessQueueHelper(); 
            
    /** Will create a required */
    public ProcessingQueue getQueue(String queueName) throws WTException {
        ProcessingQueue theProcessingQueue = QueueHelper.manager.getQueue(queueName);
        boolean starting = false;
        if (theProcessingQueue==null) {
            starting = true;
            theProcessingQueue = createProcessingQueue(queueName);
        }
        
        if (!theProcessingQueue.getQueueState().equals("STARTED") && !starting) {
            logger.warn("Watermarking Queue {0} is not running.", queueName);
        }
        return theProcessingQueue;
    }//getQueue

    /**
     * Add a queue entry as the administrator, bypass access control<p>
     * ServerSide only.
     **/
    public void addQueueEntry(ProcessingQueue theQueue,String methodName, String className, Class classList[], Object paramList[] ) throws WTException {
        boolean accessEnforced =  SessionServerHelper.manager.isAccessEnforced();
        SessionServerHelper.manager.setAccessEnforced(false);
        try {
            WTPrincipal currentUser = SessionHelper.manager.getAdministrator();
            theQueue.addEntry(currentUser, methodName, className, classList, paramList);
        } finally {
            SessionServerHelper.manager.setAccessEnforced(accessEnforced);
        }
    }//addQueueEntryRemote


    public ProcessingQueue createProcessingQueue(String queueName)  throws WTException {
        try {
            ProcessingQueue theQueue = (ProcessingQueue) QueueHelper.manager.getQueue(queueName, ProcessingQueue.class);
            if(theQueue == null) {
                String currentUser = SessionHelper.getPrincipal().getName();
                try {
                    SessionHelper.manager.setAdministrator();
                    logger.error("Information: Creating new queue {0}",queueName);
                    theQueue = QueueHelper.manager.createQueue(queueName, true);
                    theQueue = (ProcessingQueue) QueueHelper.manager.getQueue(queueName, ProcessingQueue.class);

      
                } finally {
                    SessionHelper.manager.setPrincipal(currentUser);
                }
            }
            return theQueue;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }//addQueue


}
