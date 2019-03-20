<%--
  Created by IntelliJ IDEA.
  User: 阳光
  Date: 2019/3/15
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <center>
    <form>
    <input type="text" size="10">查询 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;
    <a href="/pro/addpro1.do"><input type="button" value="添加"></a>
  <table>
    <tr>`
      <td><input type="checkbox" id="box"></td>
      <td>ID</td>
      <td>产品名称</td>
      <td>产品价格</td>
      <td>产品类型</td>
      <td>操作</td>
    </tr>
    <c:forEach items="${prolist}" var="pro">
    <tr>
      <td><input type="checkbox" id="${pro.id}"></td>
      <td>${pro.id}</td>
      <td>${pro.name}</td>
      <td>${pro.price}</td>
      <td>${pro.productType.name}</td>
      <td>
        <a href="/pro/deletepro.do?id=${pro.id}">删除</a>
        <a href="/pro/updatepro1.do?id=${pro.id}">修改</a>
      </td>
    </tr>
    </c:forEach>
  </table>
    </form>
  </center>
  </body>
</html>
