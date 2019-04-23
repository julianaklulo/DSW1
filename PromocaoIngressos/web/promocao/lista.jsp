<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Promoção de Ingressos</title>
    </head>
    <body>
        <center>
            <h1>Gerenciamento de Promoções</h1>
            <h2>
                <a href="promocoes/cadastro">Adicione Nova Promoção</a>
            </h2>
        </center>
        <div align="center">
            <table border="1" cellpadding="5">
                <caption><h2>Lista de Promoções</h2></caption>
                <tr>
                    <th>ID</th>
                    <th>URL</th>
                    <th>CNPJ</th>
                    <th>Nome da Peça</th>
                    <th>Preço</th>
                    <th>Horário</th>
                    <th>Ações</th>
                </tr>
                <c:forEach var="promocao" items="${listaPromocoes}">
                    <tr>
                        <td><c:out value="${promocao.id}" /></td>
                        <td><c:out value="${promocao.url}" /></td>
                        <td><c:out value="${promocao.cnpj}" /></td>
                        <td><c:out value="${promocao.nomePeca}" /></td> 
                        <td><c:out value="${promocao.preco}" /></td>
                        <td><c:out value="${promocao.dataHora}" /></td>
                        <td>
                            <a href="promocoes/edicao?id=<c:out value='${promocao.id}' />">Edição</a>
                            <a href="promocoes/remocao?id=<c:out value='${promocao.id}' />"onclick="return confirm('Tem certeza de que deseja excluir este item?');">Remoção</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>