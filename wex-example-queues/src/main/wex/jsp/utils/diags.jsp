<%@ page import="com.wincomplm.wex.kernel.api.invoke.WexInvoker"%>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Example Queue Diagnostics</title>
        <style>
            <%@ include file="kernel-css.jspf"%>
        </style>
        <script src="../lib/jquery-3.6.1.min.js"></script>
    </head>
    <body style="font-family: Arial; font-size: 90%; margin: 20px;  margin-top: 60px; ">
        <div class="wex-header">Example Queue</div>
        <button class="wex-button wex-close" onClick="window.close()">Close</button>

        <table style="font-size: 90%">
            <tr><td>Text for Q</td>
                <td><input class="wex-input" value="Example" id="wex-diags-text" size="30"/></td>
                <td></td>
                <td><button class="wex-button wex-button-active" onclick="doAction()">Add queue entry</button></td>
            </tr>
        </table>

        <h4>Result</h4>
        <div class="wex-results" id="wex-diags-result"></div>

        <script language="JavaScript">
            var doAction = function () {
                var result = $("#wex-diags-result");
                result.html("Running....");
                var text = $("#wex-diags-text").val();
                $.ajax({
                    url: "rundiags.jsp",
                    data: {'text': text},
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



