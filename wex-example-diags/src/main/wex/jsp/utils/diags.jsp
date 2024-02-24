<%@ page import="com.wincomplm.wex.kernel.api.invoke.WexInvoker"%>
<%
    String urlpath = request.getRequestURI(); // Get the full URL
    urlpath=urlpath.substring(0,request.getRequestURI().lastIndexOf("/")); // Shorten
    String jspath =  urlpath.replace("/jsp/","/javascript/"); // Adjust to new paths
    String csspath = urlpath.replace("/jsp/","/css/");
%>
<html>
    
    <head>
        <meta charset="UTF-8">
        <title>Example Extension Diagnostics</title>
        <link href="<%=csspath%>/diags.css" rel="stylesheet"></link>
        <script src="<%=jspath%>/libs/jquery-3.6.1.min.js"></script>
    </head>
    <body style="font-family: Arial; font-size: 90%; margin: 20px;  margin-top: 60px; ">
        <div class="wex-header">Example Diagnostics</div>
        <button class="wex-button wex-close" onClick="window.close()">Close</button>

        <table style="font-size: 90%">
            <tr><td>Part OID</td>
                <td><input  class="wex-input" id="wex-diags-oid" size="30"/></td>
                <td></td>
                <td><button class="wex-button wex-button-active" onclick="doAction()">Test</button></td>
            </tr>
        </table>

        <h4>Result</h4>
        <div class="wex-results" id="wex-diags-result"></div>

        <script language="JavaScript">
            var doAction = function () {
                var result = $("#wex-diags-result");
                result.html("Running....");
                var oid = $("#wex-diags-oid").val();
                $.ajax({
                    url: "rundiags.jsp",
                    data: {'oid': oid},
                    success: function (data) {
                        result.html(data);
                    }
                }).fail(function () {
                    result.html('Failed');
                });
            }
        </script>

    </body>
</html>



