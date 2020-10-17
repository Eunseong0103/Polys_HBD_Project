<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:useBean id="comp" class="www.kopohanbando.com.complain.vo.ComplainDAO" />

<!DOCTYPE HTML>
<html lang="kr" dir="ltr">
    <head>
        <meta charset="utf-8">
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

        <!--Stylesheet-->
        <link rel="stylesheet" href="resources/css/Complain.css">

        <!-- Script -->
        <script type="text/javascript" src="resources/js/Complain.js"></script>

        <title>[한반도] 생활관 통합 정보 시스템</title>
    </head>
    <%
    	String pattern = "yyyy-MM-dd";
    	SimpleDateFormat simple = new SimpleDateFormat(pattern);
    	Calendar cal = Calendar.getInstance();
    	String date = simple.format(cal.getTime());
    %>
    <%@ include file="TopBar.jsp" %>
    <body>
        <div id = "complain_container">
            <div id = "wrapper_top" class="jumbotron">
                <h1 class="display-4 text-center">불만/건의사항 작성</h1>
            </div>
            <div id = "wrapper_bottom" class="container">
                <div id = "complain_subtitle">
                    불만/건의사항 작성
                </div>
                <form method = "post" action = "ComplainProc.jsp" id = "complain_form">
                    <div id = "complain_data_top" class = "row">
                        <div id = "complain_type" class = "col">
                            <a style="font-weight: bold; font-size: 20px;">종류　</a><br>
                            <select name="articleType" id="complainType" class="form-control">
                                <option value="시설 보수요청">시설 보수요청</option>
                                <option value="불만사항">불만사항</option>
                                <option value="건의사항">건의사항</option>
                                <option value="기타">기타</option>
                            </select>
                        </div>
                    </div>
                    <div id = "complain_data_middle" class = "row">
                        <div id = "user_roomnumber" class = "col">
                            <a style="font-size: 20px;">호실</a><br>
                            <input type = "text" name="userNumber" id = "roomNumber" >
                        </div>
                        <div id = "user_name" class = "col">
                            <a style="font-size: 20px;">이름　</a><br>
                            <input type = "text" name="userNamed" id = "userName" value = "<%=id %>" disabled>
                        </div>
                    </div>
                    <div id = "complain_data_bottom" class = "row">
                        <div id = "complain_date" class="col">
                            <a style="font-size: 20px;">일자　</a><br>
                            <input type = "text" name="selectDate" id="complainDate" value="<%=date%>" disabled>
                        </div>
                    </div>
                    <div id = "complain_content">
                        <a style="font-size: 20px; font-weight: bold;">내용　</a>
                        <textarea name="compContent" id = "complainContent" class="form-control" rows="10" style="resize: none;"></textarea>
                    </div>
                    <div id = "complain_file" class="filebox">
                        <a style="font-size: 20px; font-weight: bold">첨부파일</a>
                        <input class="upload-name" disabled="disabled">
                        <label for="input-file">첨부파일</label>
                        <input type="file" name="files" id="input-file" class="upload-hidden">
                    </div>
                    <div id = "complain_button">
                        <button type = "submit" id = "complain_write" class = "btn btn-primary">확인</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>