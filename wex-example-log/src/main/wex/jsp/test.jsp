<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="com.wincomplm.wex.kernel.api.invoke.WexInvoker"%>
<% WexInvoker.invoke("com.wincomplm.wex-example-log","methods.createLog"); %>
<html>
    <body style="font-family: Arial, Helvetica, sans-serif;">
        <h3>Log test - download logs to check</h3>
    </body>
</html>