<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Promoção de Ingressos</title>
    </head>
    <body>
        <center>
            <h1>Promoções do Site</h1>
        </center>
        <div align="center">
            <table border="1" cellpadding="5">
                <caption><h2>Promoções do Site</h2></caption>
                <tr>
                    <th>URL</th>
                    <th>CNPJ</th>
                    <th>Nome da Peça</th>
                    <th>Preço</th>
                    <th>Horário</th>
                </tr>
                <c:forEach var="promocao" items="${listaPromocoes}">
                    <tr>
                        <td><c:out value="${promocao.url}" /></td>
                        <td><c:out value="${promocao.cnpj}" /></td>
                        <td><c:out value="${promocao.nomePeca}" /></td>
                        <td><c:out value="${promocao.preco}" /></td>
                        <td><c:out value="${promocao.dataHora}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>