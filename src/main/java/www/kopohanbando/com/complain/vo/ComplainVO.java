package www.kopohanbando.com.complain.vo;

import java.util.Date;

public class ComplainVO {
	private int articleNumber;
	private String roomNumber;
	private String articleType;
	private Date insertDate;
	private String attachedFile;
	private String articleContent;
	private String member_userID;
	

	public int getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}
	public String getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public String getAttachedFile() {
		return attachedFile;
	}

	public void setAttachedFile(String attachedFile) {
		this.attachedFile = attachedFile;
	}


	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getMember_userID() {
		return member_userID;
	}

	public void setMember_userID(String member_userID) {
		this.member_userID = member_userID;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[불만 건의 사항] "
		+ "호실 : " + roomNumber
		+ "글 타입 : " + articleType
		+ "기한 일자 :" + attachedFile
		+ "글 내용 : " + articleContent
		+ "사용자 아이디 : "+ member_userID;
	}
}
