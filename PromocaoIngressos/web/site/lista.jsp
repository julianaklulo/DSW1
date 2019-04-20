<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Promoção de Ingressos</title>
    </head>
    <body>
        <center>
            <h1>Gerenciamento de Sites</h1>
            <h2>
                <a href="cadastro">Adicione Novo Site</a>
                <a href="lista">Lista de Sites</a>
            </h2>
        </center>
        <div align="center">
            <table border="1" cellpadding="5">
                <caption><h2>Lista de Sites</h2></caption>
                <tr>
                    <th>URL</th>
                    <th>Nome</th>
                    <th>Telefone</th>
                    <th>Email</th>
                    <th>Senha</th>
                    <th>Acões</th>
                </tr>
                <c:forEach var="site" items="${listaSites}">
                    <tr>
                        <td><c:out value="${site.url}" /></td>
                        <td><c:out value="${site.nome}" /></td>
                        <td><c:out value="${site.telefone}" /></td>
                        <td><c:out value="${site.email}" /></td> 
                        <td><c:out value="${site.senha}" /></td>
                        <td>
                            <a href="edicao?url=<c:out value='${site.url}' />">Edição</a>
                            <a href="remocao?url=<c:out value='${site.url}' />"onclick="return confirm('Tem certeza de que deseja excluir este item?');">Remoção</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>