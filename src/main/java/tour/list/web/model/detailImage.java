package tour.list.web.model;

import lombok.Data;

@Data
public class detailImage {

	private int resultCode;
	private String resultMsg;
	private int numOfRows;
	private int pageNo;
	private int totalCount;
	private int contentid;
	private String imgname;
	private String originimgurl;
	private int board_idBoard;
}
