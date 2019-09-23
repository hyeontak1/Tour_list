package tour.list.web.model;

import lombok.Data;

@Data
public class board {

	public int idBoard; // 게시판번호
	public String title; // 게시판
	public String write; // 게시판내용
	public String content; // 내용
	public String date; // 작성일자
	public int member1_idNum;

	private static int offset;
	private static int listCount;

	public static int getOffset() {
		return offset;
	}

	public static void setOffset(int offset) {
		board.offset = offset;
	}

	public static int getListCount() {
		return listCount;
	}

	public static void setListCount(int listCount) {
		board.listCount = listCount;
	}
}
