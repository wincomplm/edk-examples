package com.wincomplm.wex.example.queues.impl.methods;

import com.wincomplm.wex.example.queues.impl.queue.WexProcessQueueHelper;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexMethod;
import com.wincomplm.wex.log.api.WexLogger;
import com.wincomplm.wex.log.base.api.IWexLogger;
import wt.fc.Persistable;
import wt.queue.ProcessingQueue;

/**
 *
 * @author Nassim Bouayad-Agha
 */
@WexComponent(uid = "methods", description = "Queue Methods")
public class WexQueueMethods  {

    private static IWexLogger logger = WexLogger.getLogger(WexQueueMethods.class);
    
    private static final String WEX_EXAMPLE_QUEUE = "WexExampleQueue";

    @WexMethod(name = "addProcessQueueEntry", description = "Add process Q entry")
    public void addProcessQueueEntry(String text) throws Exception {
        logger.trace("=>addProcessQueueEntry");
        ProcessingQueue queue = WexProcessQueueHelper.instance.getQueue(WEX_EXAMPLE_QUEUE);
        Object[] objects = new Object[]{text};
        Object[] params = new Object[]{"com.wincomplm.wex-example-queues", "methods.queueMethod", objects};
        Class[] klasses = new Class[]{String.class, String.class, Object[].class};
        WexProcessQueueHelper.instance.addQueueEntry(queue, "invoke", "com.wincomplm.wex.kernel.api.invoke.WexInvoker", klasses, params);
    }//addProcessQueueEntry
        
    @WexMethod(name = "queueMethod", description = "Add process Q entry")
    public void queueMethod(String text) throws Exception {
        logger.trace("=>queueMethod");
        System.out.println("Queue output: " + text);
        logger.trace("<=queueMethod");
    } //queueMethod


    @WexMethod(name = "addScheduleQueueEntry", description = "Add schedule Q entry")
    public void addScheduleQueueEntry() throws Exception {
        
    }//addScheduleQueueEntry
    
    
}
