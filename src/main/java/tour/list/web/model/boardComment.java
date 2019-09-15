package tour.list.web.model;

import lombok.Data;

@Data
public class boardComment {

	
	public int idboardComment;
	public int member1_idNum;
	public int board_idBoard;	
	public String cdate;		//댓글시간
	public String cwrite;		//댓글내용
}
