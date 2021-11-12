<%@ include file="/netmarkets/jsp/components/beginWizard.jspf"%>
<%@ taglib uri="http://www.ptc.com/windchill/taglib/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.ptc.com/windchill/taglib/mvc" prefix="mvc"%> 

<jca:wizard title="Create Part" buttonList="DefaultWizardButtonsNoApply">
    <jca:wizardStep action="wexPartNamingNikosPStep" type="com.wincomplm.wex.part.naming.nikosp"/>
</jca:wizard>

<%@include file="/netmarkets/jsp/util/end.jspf"%> 