package tour.list.web.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class detailCommonApi {
	@SerializedName("response")
	private Response response;
	
	@Data
	public class Response {
		@SerializedName("header")	private List<Header> header;
		@SerializedName("body")		private List<Body> body;
		
		@Data
		public class Header{
			@SerializedName("resultCode")	private int resultCode;
			@SerializedName("resultMsg")	private String resultMsg;
		}
		
		@Data
		public class Body{
			@SerializedName("items")		private List<Items> items;
			@SerializedName("numOfRows")	private int numOfRows;
			@SerializedName("pageNo")		private int pageNo;
			@SerializedName("totalCount")	private int totalCount;
			
			@Data
			public class Items{
				@SerializedName("contentid")	private int contentid;
				@SerializedName("contenttypeid")private int contenttypeid;
				@SerializedName("createdtime")	private String createdtime;
				@SerializedName("homepage")		private String homepage;
				@SerializedName("modifiedtime")	private String modifiedtime;
				@SerializedName("title")		private String title;
				@SerializedName("overview")		private String overview;
				@SerializedName("board_idBoard")private	int board_idBoard;
			}
		}
	}
}
