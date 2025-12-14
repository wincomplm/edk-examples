
<%@ include file="/netmarkets/jsp/components/beginWizard.jspf"%>

<%@ taglib uri="http://www.ptc.com/windchill/taglib/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.ptc.com/windchill/taglib/mvc" prefix="mvc"%>

<fmt:setLocale value="${localeBean.locale}"/>


<jca:wizard title="Example Wizard" buttonList="DefaultWizardButtonsNoApply">
    <jca:wizardStep action="edkWizardStep1" type="com.wincomplm.wex.example.wizard"/>
    <jca:wizardStep action="edkWizardStep2" type="com.wincomplm.wex.example.wizard"/>
</jca:wizard>

<%@include file="/netmarkets/jsp/util/end.jspf"%>