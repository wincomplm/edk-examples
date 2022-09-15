<%@ page import="com.wincomplm.wex.kernel.api.invoke.WexInvoker"%><%      
    String result = WexInvoker.invoke("com.wincomplm.wex-example-queues","methods.addProcessQueueEntry",request,response);
    out.println(result);
%>