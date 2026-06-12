<%@ include file="/netmarkets/jsp/util/begin.jspf"%>
<%@ taglib uri="http://www.ptc.com/windchill/taglib/mvc" prefix="mvc"%>

<%@ page import="wt.inf.container.WTContainerHelper"%>
<%@ page import="wt.org.WTUser"%>
<%@ page import="wt.session.SessionHelper"%>
<%@ page import="wt.util.WTException"%>
<%@ page import=" com.wincomplm.wex.kernel.api.invoke.WexInvoker"%>


<script> 
     var wexOpen =  function(winName,url) {
        var docWindow = window.open(url, winName, 'width=800, height=600,resizable=yes,scrollbars=yes,menubar=no,toolbar=no,location=no,status=no');
        docWindow.focus();
    } 
</script>    


<jsp:include page="${mvc:getComponentURL('com.wincomplm.wex-example-tables.wextable')}"/>

<%@ include file="/netmarkets/jsp/util/end.jspf"%>
