<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri = "http://www.wincom-plm.com/taglib/wex-kernel" prefix = "wex" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:set var="request" scope="page" value="<%=request%>"/>
${wex:invoke("com.wincomplm.wex-example-security","methods.securePage",null)}
<html>
    <body>
        <h1>Hello World</h1>
    </body>
</html>