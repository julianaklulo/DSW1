<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Promoção de Ingressos</title>
    </head>
    <body>
        <script>
            function atualizaTabela(site) {
              var xhttp = new XMLHttpRequest();
              xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                  document.getElementById("tabela").innerHTML =
                  this.responseText;
                }
              };
              var url = "listaPorSite?site=" + site;
              xhttp.open("GET", url, true);
              xhttp.send(null);
            }
        </script>
        <center>
            <p> Escolha o site: </p>
        </center>
    <div align="center">
        <c:if test="${sites != null}">
            <select name="escolheSites" onchange="atualizaTabela(this.value)">  
                <c:forEach var="site" items="${sites}">  
                    <option value="${site}"> <c:out value="${site}" /> </option>  
                </c:forEach>  
            </select>
        </c:if>
    </div>
    <div align="center" id="tabela">
        <br/>
    </div>