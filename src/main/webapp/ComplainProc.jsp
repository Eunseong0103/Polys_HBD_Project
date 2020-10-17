<%@page import="java.util.Date"%>

<%@page import="java.text.SimpleDateFormat"%>

<%@page import="www.kopohanbando.com.complain.vo.ComplainVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String id = (String)session.getAttribute("id");
    	String pw = (String)session.getAttribute("pw");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="comp" class="www.kopohanbando.com.complain.vo.ComplainDAO" />
<body>
		<%
		request.setCharacterEncoding("utf-8");
		final int i=1;
		
		String complainType = (String)request.getParameter("articleType");
		String roomNumber = (String)request.getParameter("userNumber");
		
		String content = (String)request.getParameter("compContent");
		String files = (String)request.getParameter("files");
		
		
		ComplainVO comVO = new ComplainVO();
		comVO.setRoomNumber(roomNumber);
		comVO.setArticleType(complainType);
		comVO.setAttachedFile(files);
		comVO.setArticleContent(content);
		comVO.setMember_userID(id);

		
		if(comp.insertComplain(comVO)){
			response.sendRedirect("ComplainList.jsp");
		}else{
			response.sendRedirect("Complain.jsp");
		}
		
		%>
		
</body>
</html>