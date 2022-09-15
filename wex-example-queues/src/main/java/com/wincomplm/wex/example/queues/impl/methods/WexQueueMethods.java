package com.wincomplm.wex.example.queues.impl.methods;

import com.wincomplm.wex.example.queues.impl.queue.WexProcessQueueHelper;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexMethod;
import com.wincomplm.wex.log.api.WexLogger;
import com.wincomplm.wex.log.base.api.IWexLogger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String addProcessQueueEntry(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.trace("=>addProcessQueueEntry");
        String result = ""; 
        String text = request.getParameter("text");
        ProcessingQueue queue = WexProcessQueueHelper.instance.getQueue(WEX_EXAMPLE_QUEUE);
        result = "Queue: " + queue;
        Object[] objects = new Object[]{text};
        Object[] params = new Object[]{"com.wincomplm.wex-example-queues", "methods.queueMethod", objects};
        Class[] klasses = new Class[]{String.class, String.class, Object[].class};
        WexProcessQueueHelper.instance.addQueueEntry(queue, "invoke", "com.wincomplm.wex.kernel.api.invoke.WexInvoker", klasses, params);
        result = "Queue entry added... check logs";
        return result;
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
