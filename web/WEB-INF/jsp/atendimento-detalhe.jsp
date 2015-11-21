<%-- 
    Document   : atendimento-detalhe
    Created on : Nov 21, 2015, 12:52:06 AM
    Author     : Alexandre
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1></h1>
        <form:form modelAttribute="alterarAtendimento">
            
            <p>Nome do medico: ${alterarAtendimento.medico.nome}</p>
            <form:hidden id="id" path="id" value="${alterarAtendimento.id}" />
            <form:hidden id="medico" path="medico" value="${alterarAtendimento.medico}" />
            
            <p>Nome do Procedimento: ${alterarAtendimento.procedimento}</p>
            <form:hidden id="procedimento" path="procedimento" value="${alterarAtendimento.procedimento}" />
            
            <p>Urgencia: ${alterarAtendimento.urgencia}</p>
            <form:hidden id="urgencia" path="urgencia" value="${alterarAtendimento.urgencia}" />
            
            <form:radiobutton id="situacao" path="situacao" value="Grave"/> Grave 
            <form:radiobutton id="situacao" path="situacao" value="Controlado"/> Controlado 
            <form:radiobutton id="situacao" path="situacao" value="Amenizado"/> Amenizado 
            
             <input type="submit" value="Alterar" />
        </form:form>
    </body>
</html>
