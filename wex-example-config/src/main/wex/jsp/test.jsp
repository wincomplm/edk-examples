<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="com.wincomplm.wex.kernel.api.invoke.WexInvoker"%>
<html>
    <body style="font-family: Arial, Helvetica, sans-serif;">
        <h1>Config Testing</h1>
        <%= (String) WexInvoker.invoke("com.wincomplm.wex-example-config","methods.test") %>
    </body>
</html>