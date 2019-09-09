package tour.list.web.model;

import lombok.Data;

@Data
public class board_comment {

	
	public int idboard_comment;
	public int member1_id_num;
	public int board_id_board;	
	public String cdate;		//댓글시간
	public String cwrite;		//댓글내용
}
