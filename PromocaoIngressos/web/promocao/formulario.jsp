<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Promoção de Ingressos</title>
    </head>
    <body>
        <center>
            <h1>Gerenciamento de Promoções</h1>
        </center>
        <div align="center">
            <c:if test="${promocao != null}">
                <form action="atualizacao" method="post">
            </c:if>
            <c:if test="${promocao == null}">
                <form action="insercao" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${promocao != null}">
                            Edição
                        </c:if>
                        <c:if test="${promocao == null}">
                            Cadastro
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${promocao != null}">
                    <input type="hidden" name="id" value="<c:out value='${promocao.id}' />" />
                </c:if>
                <c:if test="${promocao != null}">
                    <tr>
                        <th>Id: </th>
                        <td>
                            <input type="text" name="id" size="100" value="<c:out value='${promocao.id}' />"/>
                        </td>
                    </tr>
                    </c:if>
                <tr>
                    <th>URL: </th>
                    <td>
                        <input type="text" name="url" size="100" value="<c:out value='${promocao.url}' />"/>
                    </td>
                </tr>
                <tr>
                    <th>CNPJ: </th>
                    <td>
                        <input type="text" name="cnpj" size="100" value="<c:out value='${promocao.cnpj}' />"/>
                    </td>
                </tr>
                <tr>
                    <th>Nome da Peça: </th>
                    <td>
                        <input type="text" name="nomePeca" size="100" value="<c:out value='${promocao.nomePeca}' />"/>
                    </td>
                </tr>
                <tr>
                    <th>Preço </th>
                    <td>
                        <input type="text" name="preco" size="100" value="<c:out value='${promocao.preco}' />"/>
                    </td>
                </tr>
                <tr>
                    <th>Dia e Horário: </th>
                    <td>
                        <input type="text" name="dataHora" size="100" value="<c:out value='${promocao.dataHora}' />"/>
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