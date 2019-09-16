package tour.list.web.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class searchFestivalApi {
	   @SerializedName("response")
	   private Response response;
	   
	  
	   @Data
	   public class Response {
	      @SerializedName("header")      private List<Header> header;
	      @SerializedName("body")        private List<Body> body;
	      
	   
	  
	      @Data
	      public class Header {
	         @SerializedName("resultCode")            private int resultCode;
	         @SerializedName("resultMsg")      private String resultMsg;  
	         }
	      
	      @Data
	      public class Body{
	          @SerializedName("items")      private List<Items> items;
	         @SerializedName("numOfRows")            private int numOfRows;
	          @SerializedName("pageNo")      private int pageNo;
	          @SerializedName("totalCount")      private int totalCount;
	          
	          public class Items{
	             @SerializedName("item")      private List<Item> item;
	             
	             public class Item{
	                @SerializedName("addr1")            private String addr1;
	                  @SerializedName("contentid")      private int contentid;
	                  @SerializedName("contenttypeid")      private int contenttypeid;
	                  @SerializedName("createdtime")      private String createdtime;
	                  @SerializedName("eventenddate")      private String eventenddate;
	                  @SerializedName("eventstartdate")      private String eventstartdate;

	                  @SerializedName("firstimage")      private String firstimage;
	                  @SerializedName("firstimage2")      private String firstimage2;
	                  @SerializedName("modifiedtime")      private String modifiedtime;
	                  @SerializedName("tel")      private String tel;
	                  @SerializedName("title")      private String title;
	                
	             }
	             
	             
	          }
	         
	      }
	      }
  }