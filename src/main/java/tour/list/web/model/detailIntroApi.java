package tour.list.web.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class detailIntroApi {
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
				@SerializedName("contentid")				private int contentid;
				@SerializedName("contenttypeid")			private int contenttypeid;
				@SerializedName("chkbabycarriage")			private	String chkbabycarrigae;
				@SerializedName("chkcreditcard")			private String chkcreditcard;
				@SerializedName("chkpet")					private String chkpet;
				@SerializedName("chkbabycarriageculture")	private String chkbabycarriageculture;
				@SerializedName("chkcreditcardculture")		private String chkcreditcardculture;
				@SerializedName("chkpetculture")			private String chkpetculture;
				@SerializedName("restdateculture")			private String restdateculture;
				@SerializedName("usefee")					private	String usefee;
				@SerializedName("usetimeculture")			private String usetimecultue;
				@SerializedName("eventenddate")				private	String eventenddate;
				@SerializedName("eventhomepage")			private String eventhomepage;
				@SerializedName("eventplace")				private String eventplace;
				@SerializedName("eventstartdate")			private String eventstartdate;
				@SerializedName("placeinfo")				private String placeinfo;
				@SerializedName("playtime")					private	String playtime;
				@SerializedName("program")					private String program;
				@SerializedName("sponsor2")					private String sponsor2;
				@SerializedName("sponsor2tel")				private	String sponsor2tel;
				@SerializedName("usetimefestival")			private String usetimefestival;
				@SerializedName("chkbabycarriageleports")	private String chkbabycarriageleports;
				@SerializedName("chkcreditcardleports")		private String chkcreditcardleports;
				@SerializedName("chkpetleports")			private String chkpetleports;
				@SerializedName("board_idBoard")			private int board_idBoard;
			}
		}
	}
}
