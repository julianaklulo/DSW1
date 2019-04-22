<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Promoção de Ingressos</title>
    </head>
    <body>
        <center>
            <h1>Gerenciamento de Sites</h1>
        </center>
        <div align="center">
            <c:if test="${site != null}">
                <form action="atualizacao" method="post">
            </c:if>
            <c:if test="${site == null}">
                <form action="insercao" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${site != null}">
                            Edição
                        </c:if>
                        <c:if test="${site == null}">
                            Cadastro
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${site != null}">
                    <input type="hidden" name="url" value="<c:out value='${site.url}' />" />
                </c:if>
                <tr>
                    <th>URL: </th>
                    <td>
                         <input type="text" name="url" size="100" value="<c:out value='${site.url}' />"/>
                    </td>
                </tr>
                <tr>
                    <th>Nome: </th>
                    <td>
                        <input type="text" name="nome" size="100" value="<c:out value='${site.nome}' />"/>
                    </td>
                </tr>
                <tr>
                    <th>Telefone: </th>
                    <td>
                        <input type="text" name="telefone" size="100" value="<c:out value='${site.telefone}' />"/>
                    </td>
                </tr>
                <tr>
                    <th>Email: </th>
                    <td>
                        <input type="text" name="email" size="100" value="<c:out value='${site.email}' />"/>
                    </td>
                </tr>
                <tr>
                    <th>Senha: </th>
                    <td>
                        <input type="text" name="senha" size="100" value="<c:out value='${site.senha}' />"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Salvar" />
                    </td>
                </tr>
            </table>
            </form>
        </div>
    </body>
</html> 