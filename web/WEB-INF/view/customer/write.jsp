<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <c:choose>
        <c:when test="${requestScope.iboard > 0}">
            <h1>글쓰기</h1>
            <form action="upd" method="post">
    </c:when>
        <c:otherwise>
        <h1>수정</h1>
        <form action="write" method="post">
        </c:otherwise>
    </c:choose>
        <input type="hidden" name="iboard" value="${requestScope.iboard}">
        <div>
            <label>제목 : <input type="text" name="title" value="<c:out value='${requestScope.data.title}'/>">
            </label>
        </div>
        <div>
            <label>내용 : <textarea name="ctnt"><c:out value="${requestScope.data.ctnt}" /></textarea>
            </label>
        </div>
        <div><input type="submit" value="${submitVal}"></div>
    </form>
</div>