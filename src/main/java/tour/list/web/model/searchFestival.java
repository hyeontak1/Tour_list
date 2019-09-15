package tour.list.web.model;

import lombok.Data;

@Data
public class searchFestival {

	private int resultCode;
	private String resultMsg;
	private int numOfRows;
	private int pageNo;
	private int totalCount;
	private String addr1;
	private int contentid;
	private int contentypeid;
	private String createdtime;
	private String eventstartdate;
	private String eventenddate;
	private String firstimage;
	private String firstimage2;
	private String modifiedtime;
	private String tel;
	private String title;
	private int board_idBoard;
}
