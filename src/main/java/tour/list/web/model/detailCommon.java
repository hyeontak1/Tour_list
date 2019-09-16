package tour.list.web.model;

import lombok.Data;

@Data
public class detailCommon {

	private int resultCode;
	private String resultMsg;
	private int numOfRows;
	private int pageNo;
	private int totalCount;
	private int contentid;
	private int contenttypeid;
	private String createdtime;
	private String homepage;
	private String modifiedtime;
	private String title;
	private String overview;
	private int board_idBoard;
}
