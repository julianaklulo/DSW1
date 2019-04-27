<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Promoção de Ingressos</title>
    </head>
    <body>
        <script>
            function atualizaTabela(teatro) {
              var xhttp = new XMLHttpRequest();
              xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                  document.getElementById("tabela").innerHTML =
                  this.responseText;
                }
              };
              var url = "listaPorTeatro?teatro=" + teatro;
              xhttp.open("GET", url, true);
              xhttp.send(null);
            }
        </script>
        <center>
            <p> Escolha o teatro </p>
        </center>
    <div align="center">
        <c:if test="${teatros != null}">
            <select name="escolheTeatros" onchange="atualizaTabela(this.value)">  
                <c:forEach var="teatro" items="${teatros}">  
                    <option value="${teatro}"> <c:out value="${teatro}" /> </option>  
                </c:forEach>  
            </select>
        </c:if>
    </div>
    <div align="center" id="tabela">
        <br/>
    </div>