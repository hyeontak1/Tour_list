package tour.list.web.model;

import lombok.Data;

@Data
public class board {

	public int idBoard;	//게시판번호
	public String title;	//게시판
	public String write;	//게시판내용
	public String content;	//내용
	public String date;		//작성일자
	public int member1_idNum;
	
}
