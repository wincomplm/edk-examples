<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri = "http://www.wincom-plm.com/taglib/wex-kernel" prefix = "wex" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
${wex:invoke("com.wincomplm.wex-example-security","methods.securePage",request,response)}
<%
    String id = request.getParameter("id");
%>
Payload: <%= id %> (uses id URL parameter)