<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<form action="/user/login" method="post">
    <div>
        <div>닉네임</div>
        <div><input type="text" name="nickname"></div>
    </div>
    <div>
        <div><input type="submit" value="가입"></div>
    </div>
</form>
