<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="com.wincomplm.wex.kernel.api.invoke.WexInvoker"%>
<html>
    <body style="font-family: Arial, Helvetica, sans-serif;">
        <%= (String) WexInvoker.invoke("com.wincomplm.wex-example-rest","wex-example-rest-methods.getModifiedParts", request,response) %>
</html>