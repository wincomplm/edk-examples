<%@ include file="/netmarkets/jsp/util/begin.jspf"%>
<%@ taglib prefix="wctags" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.ptc.com/windchill/taglib/mvc" prefix="mvc"%>
<%@ taglib uri = "http://www.wincom-plm.com/taglib/wex-kernel" prefix = "wex" %>    
<%@ taglib uri="http://www.ptc.com/windchill/taglib/wrappers" prefix="w"%>
<%@ taglib uri="http://www.ptc.com/windchill/taglib/components" prefix="jca"%>

<table>
    <tr>
        <td><w:label styleClass="ppdata" labelForElementId="partNumberingNikosPPrefix" value="Prefix for Part Name:"/></td>		 
        <td><w:textBox propertyLabel="Prefix for Part Name:" id="partNumberingNikosPPrefix" name="partNumberingNikosPPrefix" maxlength="300" size="27" required="false"/></td>
    </tr>
</table>




<%@ include file="/netmarkets/jsp/util/end.jspf"%> 
