<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page 
	import="java.util.Date"
	import="java.text.SimpleDateFormat"
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>피자 주문 페이지</h1>

    <h2>오늘의 날씨</h2>
    <%
        Date today = new Date();
       	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
    %>
    
    <h4><%=sdf.format(today)%></h4>
    <br><br>

    <!--
        주문자정보, 주문정보 입력받아서
        서버에 결제 요청(servlet에 전달)
        controller -> pizzaServlet.java

        응답을 위한 jsp페이지 필요
        pizza > pizzaPayment.jsp
    -->

    <form action="/jsp/confirmPizza.do" method="GET">
        <fieldset>
            <legend>주문자 정보</legend>
            <table>
                <tr>
                    <td>이름</td>
                    <td><input type="text" name="userName" required></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><input type="text" name="phone" required></td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><input type="text" name="address" required></td>
                </tr>
                <tr>
                    <td>요청메세지</td>
                    <td><textarea type="text" name="massage" required></textarea></td>
                </tr>
            </table>
        </fieldset>
        <br>
        <fieldset>
            <legend>주문정보</legend>
            <table>
                <tr>
                    <th>피자</th>
                    <td>
                        <select name="pizza">
                            <option >콤비네이션</option>
                            <option >치즈피자</opt ion>
                            <option >포테이토피자</option>
                            <option >고구마피자</option>
                            <option >하와이안피자</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>토핑</th>
                    <td>
                        <input type="checkbox" name="topping" value="고구마무스"> 고구마무스
                        <input type="checkbox" name="topping" value="치즈크러스트"> 치즈크러스트
                        <input type="checkbox" name="topping" value="치즈바이트"> 치즈바이트
                        <br>
                        <input type="checkbox" name="topping" value="치즈추가"> 치즈추가
                        <input type="checkbox" name="topping" value="베이컨/소세지"> 베이컨/소세지
                        <input type="checkbox" name="topping" value="파인애플"> 파인애플
                    </td>
                </tr>
                <tr>
                    <th>사이드</th>
                    <td>
                        <input type="checkbox" name="side" value="콜라">콜라
                        <input type="checkbox" name="side" value="사이다">사이다
                        <input type="checkbox" name="side" value="갈릭">갈릭
                        <br>
                        <input type="checkbox" name="side" value="핫소스">핫소스
                        <input type="checkbox" name="side" value="피클">피클
                        <input type="checkbox" name="side" value="파마산">파마산

                    </td>
                </tr>
                <tr>
                    <th>결제방식</th>
                    <td>
                        <input type="radio" name="payment" value="card" checked> 카드결제
                        <input type="radio" name="payment" value="cash"> 현글결제
                    </td>
                </tr>
            </table>
        </fieldset>

        <br>

        <input type="submit" value="주문">
        <input type="reset">
    </form>
</body>
</html>