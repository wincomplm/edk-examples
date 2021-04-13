<%@ page import="com.wincomplm.wex.kernel.api.invoke.WexInvoker"%>

<%@ include file="header.jspf"%>

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
    
    var doAction =  function() {
        var result = $("#wex-diags-result");
        result.html("Running....");
        var oid = $("#wex-diags-oid").val();
        $.ajax({
            url: "rundiags.jsp",
            data: {'oid': oid},
            success: function (data) { result.html(data); }
        }).fail(function () {
            result.html('Failed');
        });
    }


</script>

<%@ include file="footer.jspf"%>


