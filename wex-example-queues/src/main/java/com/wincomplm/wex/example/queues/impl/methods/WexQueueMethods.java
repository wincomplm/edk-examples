package com.wincomplm.wex.example.queues.impl.methods;

import com.wincomplm.wex.example.queues.impl.queue.WexQueueHelper;
import com.wincomplm.wex.kernel.impl.annotations.WexComponent;
import com.wincomplm.wex.kernel.impl.annotations.WexMethod;
import com.wincomplm.wex.log.api.WexLogger;
import com.wincomplm.wex.log.base.api.IWexLogger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wt.queue.ProcessingQueue;
import wt.queue.QueueHelper;
import wt.queue.ScheduleQueue;

/**
 *
 * @author Nassim Bouayad-Agha
 */
@WexComponent(uid = "methods", description = "Queue Methods")
public class WexQueueMethods  {

    private static IWexLogger logger = WexLogger.getLogger(WexQueueMethods.class);
    
    private static final String WEX_EXAMPLE_PROCESS_QUEUE = "WexExampleProcessQueue";
    private static final String WEX_EXAMPLE_SCHEDULED_QUEUE = "WexExampleScheduleQueue";

    @WexMethod(name = "addQueueEntry", description = "Add process Q entry")
    public String addQueueEntry(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.trace("=>addQueueEntry");
        String result = ""; 
        String process = request.getParameter("process");
        if (process.equalsIgnoreCase("true")) {
            logger.trace("<addQueueEntry");
            return addProcessQueueEntry(request,response);
        } else {
            logger.trace("=>addQueueEntry");
            return addScheduledQueueEntry(request,response);
        }
    }//addProcessQueueEntry
    

    
    public String addScheduledQueueEntry(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.trace("=>addScheduledQueueEntry");
        String text = request.getParameter("text");
        
        Object[] objects = new Object[]{text};
        Object[] params = new Object[]{"com.wincomplm.wex-example-queues", "methods.queueMethod", objects};
        Class[] klasses = new Class[]{String.class, String.class, Object[].class};
        
        /** 
         * Note for an entry that executes to repeat e.g. once a day
         * Ensure the queue entry add the next queue entry once it completes
         */
        long time2execute  = System.currentTimeMillis() + 60000; // one minute in the future
        WexQueueHelper.instance.addScheduledEntry(WEX_EXAMPLE_SCHEDULED_QUEUE,klasses,params,time2execute);
        String result="Added entry to execute in 1 minute";
        logger.trace("<=addScheduledQueueEntry");
        return result;
    }//addProcessQueueEntry
    
    public String addProcessQueueEntry(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.trace("=>addProcessQueueEntry");
        String result = ""; 
        String text = request.getParameter("text");
        ProcessingQueue queue = WexQueueHelper.instance.getProcessQueue(WEX_EXAMPLE_PROCESS_QUEUE);
        result = "Queue: " + queue;
        Object[] objects = new Object[]{text};
        Object[] params = new Object[]{"com.wincomplm.wex-example-queues", "methods.queueMethod", objects};
        Class[] klasses = new Class[]{String.class, String.class, Object[].class};
        WexQueueHelper.instance.addQueueEntry(queue, "invoke", "com.wincomplm.wex.kernel.api.invoke.WexInvoker", klasses, params);
        result = "Queue entry added... check logs";
        logger.trace("<=addProcessQueueEntry");
        return result;
    }//addProcessQueueEntry
        
    @WexMethod(name = "queueMethod", description = "Add process Q entry")
    public void queueMethod(String text) throws Exception {
        logger.trace("=>queueMethod");
        System.out.println("Queue output: " + text);
        logger.trace("<=queueMethod");
    } //queueMethod


    
}
