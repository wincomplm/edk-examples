<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri = "http://www.wincom-plm.com/taglib/wex-kernel" prefix = "wex" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:set var="request" scope="page" value="<%=request%>"/>
<c:set var="response" scope="page" value="<%=response%>"/>
${wex:invoke("com.wincomplm.wex-example-security","test-methods.run",request,response)}