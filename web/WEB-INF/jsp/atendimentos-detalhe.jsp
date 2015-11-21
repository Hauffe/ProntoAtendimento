<%-- 
    Document   : atendimentos-detalhe
    Created on : Nov 21, 2015, 12:18:00 AM
    Author     : Alexandre
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atendimentos:</title>
    </head>
    <body>
        <h1>Atendimentos</h1>
        <div>
        <c:forEach var="atendimento" items="${atendimentos}">
            <div>
                <p>${atendimento.id}</p>
                <p>${atendimento.procedimento}</p>
                <p>${atendimento.urgencia}</p>
                <p>${atendimento.situacao}</p>
                <p>${atendimento.medico.nome}</p>
                <p>${atendimento.medico.especialidade}</p>
                <a href="consulta?atendimentoId=${atendimento.id}&medicoId=${atendimento.medico.id}">Mudar Situação</a>
            </div>
        </c:forEach>
        </div>
    </body>
</html>
