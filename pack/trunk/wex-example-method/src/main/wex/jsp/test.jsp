<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="com.wincomplm.wex.kernel.api.invoke.WexInvoker"%>
<html>
    <body style="font-family: Arial, Helvetica, sans-serif;">
        <h1>Sample method examples</h1>
        <table>
            <tr><td><b>Simple call</b></td><td><%= (String) WexInvoker.invoke("com.wincomplm.wex-example-method","methods.example") %></td></tr>
            <tr><td><b>Call with argument</b></td><td><%= (String) WexInvoker.invoke("com.wincomplm.wex-example-method","methods.argName","Bob") %></td></tr>
            <tr><td><b>Windchill user name</b></td><td><%= (String) WexInvoker.invoke("com.wincomplm.wex-example-method","methods.userName") %></td></tr>
        </table>
    </body>
</html>