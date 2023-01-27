<%@ page import="com.sadad.portal.common.utils.BillerSendBatchFileTypes"%>
<%@ page import="com.sadad.portal.common.utils.BankSendBatchFileTypes"%>
<%@ page import="com.sadad.portal.common.utils.SadadOrganisationType2"%>
<% pageContext.setAttribute("billerFileTypes", BillerSendBatchFileTypes.values()); %>
<% pageContext.setAttribute("bankFileTypes", BankSendBatchFileTypes.values()); %>
<% pageContext.setAttribute("organisationTypes", SadadOrganisationType2.values()); %>

<jsp:directive.include file="../../common/JspDeclarations.jspf" />
