<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri = "http://www.wincom-plm.com/taglib/wex-kernel" prefix = "wex" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="request" scope="page" value="<%=request%>"/>
<c:set var="response" scope="page" value="<%=response%>"/>

Feedback: ${wex:invoke("com.wincomplm.wex-part-naming-nikosp","wex-naming-helper.create-part-feedback",request,response)}
<br>
Created part: ${wex:invoke("com.wincomplm.wex-part-naming-nikosp","wex-naming-helper.create-part",request,response)}
