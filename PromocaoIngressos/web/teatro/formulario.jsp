<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Promoção de Ingressos</title>
    </head>
    <body>
        <center>
            <h1>Gerenciamento de Teatros</h1>
        </center>
        <div align="center">
            <c:if test="${teatro != null}">
                <form action="atualizacao" method="post">
            </c:if>
            <c:if test="${teatro == null}">
                <form action="insercao" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${teatro != null}">
                            Edição
                        </c:if>
                        <c:if test="${teatro == null}">
                            Cadastro
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${teatro != null}">
                    <input type="hidden" name="cnpj" value="<c:out value='${teatro.cnpj}' />" />
                </c:if>
                <tr>
                    <th>CNPJ: </th>
                    <td>
                         <input type="text" name="cnpj" size="100" value="<c:out value='${teatro.cnpj}' />"/>
                    </td>
                </tr>
                <tr>
                    <th>Nome: </th>
                    <td>
                        <input type="text" name="nome" size="100" value="<c:out value='${teatro.nome}' />"/>
                    </td>
                </tr>
                <tr>
                    <th>Cidade: </th>
                    <td>
                        <input type="text" name="cidade" size="100" value="<c:out value='${teatro.cidade}' />"/>
                    </td>
                </tr>
                <tr>
                    <th>Email: </th>
                    <td>
                        <input type="text" name="email" size="100" value="<c:out value='${teatro.email}' />"/>
                    </td>
                </tr>
                <c:if test="${teatro == null}">
                    <tr>
                        <th>Senha: </th>
                        <td>
                            <input type="text" name="senha" size="100" value="<c:out value='' />"/>
                        </td>    
                    </tr>
                </c:if>
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