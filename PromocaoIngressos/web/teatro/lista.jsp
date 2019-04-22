<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Promoção de Ingressos</title>
    </head>
    <body>
        <center>
            <h1>Gerenciamento de Teatros</h1>
            <h2>
                <a href="cadastro">Adicione Novo Teatro</a>
                <a href="lista">Lista de Teatros</a>
            </h2>
        </center>
        <div align="center">
            <table border="1" cellpadding="5">
                <caption><h2>Lista de Teatros</h2></caption>
                <tr>
                    <th>CNPJ</th>
                    <th>Nome</th>
                    <th>Cidade</th>
                    <th>Email</th>
                    <th>Senha</th>
                    <th>Acões</th>
                </tr>
                <c:forEach var="site" items="${listaTeatros}">
                    <tr>
                        <td><c:out value="${teatro.cnpj}" /></td>
                        <td><c:out value="${teatro.nome}" /></td>
                        <td><c:out value="${teatro.cidade}" /></td>
                        <td><c:out value="${teatro.email}" /></td> 
                        <td><c:out value="${teatro.senha}" /></td>
                        <td>
                            <a href="edicao?url=<c:out value='${teatro.cnpj}' />">Edição</a>
                            <a href="remocao?url=<c:out value='${teatro.cnpj}' />"onclick="return confirm('Tem certeza de que deseja excluir este item?');">Remoção</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>