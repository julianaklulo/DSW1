<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Promoção de Ingressos</title>
    </head>
    <body>
        <center>
            <h1>Teatros Cadastrados</h1>
        </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Teatros</h2></caption>
            <tr>
                <th>CNPJ</th>
                <th>Nome</th>
                <th>Cidade</th>
            </tr>
            <c:forEach var="teatro" items="${listaTeatros}">
                <tr>
                    <td><c:out value="${teatro.cnpj}" /></td>
                    <td><c:out value="${teatro.nome}" /></td>
                    <td><c:out value="${teatro.cidade}" /></td>
                </tr>
            </c:forEach>
        </table>
        </div>
    </body>
</html>