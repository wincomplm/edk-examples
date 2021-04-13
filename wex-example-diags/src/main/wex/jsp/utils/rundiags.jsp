<%@ page import="com.wincomplm.wex.kernel.api.invoke.WexInvoker"%><%  
    
    String result = WexInvoker.invoke("com.wincomplm.wex-example-diags","methods.test",request,response);
    out.println(result);
%>