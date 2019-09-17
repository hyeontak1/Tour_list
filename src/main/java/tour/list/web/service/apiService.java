package tour.list.web.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tour.list.web.model.detailCommonApi;
import tour.list.web.model.detailImageApi;
import tour.list.web.model.detailIntroApi;
import tour.list.web.model.searchFestivalApi;
import tour.list.web.model.searchKeywordApi;

public interface apiService {
	
	public static final String BASE_URL = "http://api.visitkorea.or.kr";

	// 키워드 검색
	@GET("/openapi/service/rest/KorService/searchKeyword?ServiceKey=l2VTTN0fU0JbAUod9iD%2BKG04GF%2BWIr4GohyuKRP22H8ujU1rlliUqGxlveADrCtqIGocNfUu%2FK3EzQMXgSjEYw%3D%3D&numOfRows=6&MobileOS=AND&MobileApp=TourList&_type=json")
	Call<searchKeywordApi> getsearchKeywordApi(@Query("keyword") String keyword);
	
	// 행사 검색
	@GET("/openapi/service/rest/KorService/searchFestival?ServiceKey=l2VTTN0fU0JbAUod9iD%2BKG04GF%2BWIr4GohyuKRP22H8ujU1rlliUqGxlveADrCtqIGocNfUu%2FK3EzQMXgSjEYw%3D%3D&numOfRows=6&MobileOS=AND&MobileApp=TourList&_type=json")
	Call<searchFestivalApi> getSearchFestivalApi(@Query("eventStartDate") String eventStartDate);
	
	// 공통정보 조회
	@GET("/openapi/service/rest/KorService/detailCommon?ServiceKey=l2VTTN0fU0JbAUod9iD%2BKG04GF%2BWIr4GohyuKRP22H8ujU1rlliUqGxlveADrCtqIGocNfUu%2FK3EzQMXgSjEYw%3D%3D&numOfRows=6&MobileOS=AND&MobileApp=TourList&_type=json")
	Call<detailCommonApi> getDetailCommonApi(@Query("contentId") int contentId);
	
	// 소개정보
	@GET("/openapi/service/rest/KorService/detailIntro?ServiceKey=l2VTTN0fU0JbAUod9iD%2BKG04GF%2BWIr4GohyuKRP22H8ujU1rlliUqGxlveADrCtqIGocNfUu%2FK3EzQMXgSjEYw%3D%3D&numOfRows=6&MobileOS=AND&MobileApp=TourList&_type=json")
	Call<detailIntroApi> getDetailIntroApi(@Query("contentId") int contentId, @Query("contetnTypeId") int contetnTypeId);
	
	// 이미지
	@GET("/openapi/service/rest/KorService/detailImage?ServiceKey=l2VTTN0fU0JbAUod9iD%2BKG04GF%2BWIr4GohyuKRP22H8ujU1rlliUqGxlveADrCtqIGocNfUu%2FK3EzQMXgSjEYw%3D%3D&numOfRows=6&MobileOS=AND&MobileApp=TourList&_type=json")
	Call<detailImageApi> getDetailImageApi(@Query("contentId") int contentId);	
}
