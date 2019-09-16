package tour.list.web.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class detailImageApi {
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
				@SerializedName("imgname")		private String imgname;
				@SerializedName("originimgurl")	private String originimgurl;
				@SerializedName("board_idBoard")private int board_idBoard;
			}
		}
	}
}
