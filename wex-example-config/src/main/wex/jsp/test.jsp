<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="com.wincomplm.wex.kernel.api.invoke.WexInvoker"%>
<html>
    <body style="font-family: Arial, Helvetica, sans-serif;">
        <h1>Sample config examples</h1>
        <table>
            <tr><td><b>String config</b></td><td><%= (String) WexInvoker.invoke("com.wincomplm.wex-example-config","methods.string") %></td></tr>
    </body>
</html>