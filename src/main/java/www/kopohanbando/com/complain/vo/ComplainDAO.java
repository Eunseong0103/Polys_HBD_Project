package www.kopohanbando.com.complain.vo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.mysql.cj.Session;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ComplainDAO {
	String diver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/hbd?serverTimezone=UTC";
	String id="root";
	String pwd="1234";
	SimpleDateFormat simple = null;
	
	
	Connection conn =null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	void connect() {
		try {
			Class.forName(diver);
			conn = DriverManager.getConnection(url,id,pwd);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	void disconnect() {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public boolean loginCheck(){
		connect();
		boolean loginCon = false;
		try {
			String sql = "select userID, userPassWord from member where userID = ? and userPassWord = ?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, id);	
			rs = stmt.executeQuery();
			loginCon=rs.next();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			 disconnect();
		}
			return loginCon;
	}
	public ArrayList<ComplainVO> getComplainList() {
	      connect();
	      ArrayList<ComplainVO> compVO = new ArrayList<ComplainVO>();
	      try {
	         String GET_SQL = "SELECT * FROM complain";
	         Statement sst = conn.createStatement();
	         rs = sst.executeQuery(GET_SQL);
	         
	      
	         while (rs.next()) {
	            ComplainVO cvo = new ComplainVO();
	            cvo.setArticleNumber(rs.getInt(1));
	            cvo.setRoomNumber(rs.getString(2));
	            cvo.setArticleType(rs.getString(3));
	            cvo.setInsertDate(rs.getDate(4));
	            //cvo.setAttachedFile(rs.getString(5));
	            //cvo.setArticleContent(rs.getString(6));
	            
	            compVO.add(cvo);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      return compVO;
	   }
	
	public boolean insertComplain(ComplainVO vo){
		connect();
		boolean result = false;
		try {
			
			String sql = "insert into complain(roomNumber,articleType,attachedFile,articleContent,member_userID)values(?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,vo.getRoomNumber());	
			stmt.setString(2,vo.getArticleType());	
			stmt.setString(3, vo.getAttachedFile());
			stmt.setString(4,vo.getArticleContent());
			stmt.setString(5,vo.getMember_userID());
			
			stmt.executeUpdate();
			int count = stmt.executeUpdate();
			
			if(count==1) {
				result = true;
			}else {
				result=false;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			 disconnect();
		}
			return result;
	}
	
}
