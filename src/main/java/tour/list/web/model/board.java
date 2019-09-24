package tour.list.web.model;

import lombok.Data;

@Data
public class board {

	public int idBoard; 
	public String title; 
	public String content; 
	public String date; 
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
