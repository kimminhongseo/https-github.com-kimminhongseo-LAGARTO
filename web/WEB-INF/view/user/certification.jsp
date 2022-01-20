<%@ page import="com.port.lagarto.Const" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="wrap">
    <h1>휴대전화 인증</h1>
    <div id="certification">
        <form action="/user/certification" method="post" id="cert_form">
            <div class="form_container">
                <div>
                    <div class="input_name">휴대전화</div>
                    <div class="num_wrap">
                        <label class="num_box">
                            <select name="contact_first">
                                <option value="010">010</option>
                                <option value="011">011</option>
                                <option value="016">016</option>
                                <option value="017">017</option>
                                <option value="018">018</option>
                                <option value="019">019</option>
                            </select>
                        </label>
                        <label class="num_box">
                            <input type="number" name="contact_second" maxlength="4" data-regex="<%=Const.CONTACT_SECOND%>" required>
                        </label>
                        <label class="num_box">
                            <input type="number" name="contact_third" maxlength="4" data-regex="<%=Const.CONTACT_THIRD%>" required>
                        </label>
                    </div>
                </div>

                <div class="btn_cont">
                    <input class="object_button prop_light" type="button" value="취소">
                    <input class="object_button prop_dark" type="submit" value="인증하기">
                </div>
            </div>
        </form>
    </div>
</div>