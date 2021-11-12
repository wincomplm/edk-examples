<%@ page import="com.wincomplm.wex.kernel.api.invoke.WexInvoker"%>

<%@ include file="header.jspf"%>

<body>
    <div class="row ml-3 mt-3">
        <form  method='POST' id="wex-object-numbering">
            <label for="wex-sequence-test" >Sequence : </label>
            <input name="wex-sequence-test" type="text" id="wex-sequence-test">
            <input type="button" value="Get Sequence"  class="btn btn-secondary" onclick="getSequence()">
        </form>
    </div>
</body>

<h4>Result</h4>
<div class="wex-results" id="wex-diags-result"></div>

<script language="JavaScript">

    var getSequence = function () {
        event.stopPropagation();
        event.preventDefault();
        var name = document.getElementById("wex-sequence-test").value;
        var result = $("#wex-diags-result");
        result.html("Running....");
        $.ajax({
            url: "rundiags.jsp",
            data: {'name': name},
            success: function (data) {
                result.html(data);
            }
        }).fail(function () {
            result.html('Failed');
        });
    }


</script>

<%@ include file="footer.jspf"%>


