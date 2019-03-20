<%--
  Created by IntelliJ IDEA.
  User: 阳光
  Date: 2019/3/18
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="pro" action="/pro/updatepro2.do" >
    <form:hidden path="id"></form:hidden>
    产品名称：<form:input path="name"></form:input><br>
    产品价格：<form:input path="price"></form:input><br>
    产品类型：<form:select path="productType.id"
                      items="${all}"
                      itemLabel="name"
                      itemValue="id"></form:select><br>
    &nbsp;&nbsp;&nbsp;&nbsp;<button>修改</button>
    </select><br>
</form:form>
</body>
</html>
