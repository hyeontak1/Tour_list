package tour.list.web.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import retrofit2.Call;
import retrofit2.Retrofit;
import tour.list.web.helper.RetrofitHelper;
import tour.list.web.helper.WebHelper;



@Controller
public class RetrofitController {
   @Autowired
   WebHelper webHelper;

   @Autowired
   RetrofitHelper retrofitHelper;

   @RequestMapping(value = "/retrofit/kakao_image_search.do", method = RequestMethod.GET)
   public String kakaoImageSearch(Model model) {
      // Retrofit 객체 생성
      Retrofit retrofit = retrofitHelper.getRetrofit(KakaoSearchService.BASE_URL);

      // Service 객체를 생성한다. 구현체는 Retrofit이 자동으로 생성해 준다.
      KakaoSearchService kakaoSearchService = retrofit.create(KakaoSearchService.class);

      // 검색어 키워드 받기
      String query = webHelper.getString("query", "");

      // 검색 결과를 저장할 Beans객체 선언
      Image image = null;

      // 검색어가 존재할 경우 KakaoOpenAPI를 통해 검색 결과 받아옴
      if (!query.equals("")) {
         Call<Image> call = kakaoSearchService.getImage(query, 1, 50);

         try {
            image = call.execute().body();
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

      // View에게 변수를 전달하기 위한 값들을 Model 객체에 담는다.
      model.addAttribute("query", query);
      model.addAttribute("image", image);

      // View 경로 지정
      return "retrofit/kakao_image_search";
   }

   @RequestMapping(value = "/retrofit/kakao_book_search.do", method = RequestMethod.GET)
   public String kakaoBookSearch(Model model) {
      // Retrofit 객체 생성
      Retrofit retrofit = retrofitHelper.getRetrofit(KakaoSearchService.BASE_URL);

      // Service 객체를 생성한다. 구현체는 Retrofit이 자동으로 생성해 준다.
      KakaoSearchService kakaoSearchService = retrofit.create(KakaoSearchService.class);

      // 검색어 키워드 받기
      String query = webHelper.getString("query", "");

      // 검색 결과를 저장할 Beans 객체 선언
      Book book = null;

      // 검색어가 존재할 경우 KakaoOpenAPI를 통해 검색 결과 받아옴.
      if (!query.contentEquals("")) {
         Call<Book> call = kakaoSearchService.getBook(query, 1, 50);
         try {
            book = call.execute().body();
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

      // View에게 변수를 전달하기 위한 값들을 Model 객체에 담는다.
      model.addAttribute("query", query);
      model.addAttribute("book", book);

      // View 경로 지정
      return "retrofit/kakao_book_search";
   }

   @RequestMapping(value = "/retrofit/daily_box_office.do", method = RequestMethod.GET)
   public String dailyBoxOffice(Model model) {
      // Retrofit 객체 생성
      Retrofit retrofit = retrofitHelper.getRetrofit(KobisService.BASE_URL);

      // Service 객체를 생성한다. 구현체는 Retrofit이 자동으로 생성해 준다.
      KobisService kobisService = retrofit.create(KobisService.class);

      // 검색일 파라미터 (yyyy-mm-dd 형식)
      String date = webHelper.getString("date");

      // 검색어가 없다면 calendar 클래스를 사용하여 하루 전 날 짜 값을 yyyy-mm-dd 형식으로 생성한다.
      if (date == null) {
         Calendar c = Calendar.getInstance();
         c.add(Calendar.DAY_OF_MONTH, -1);

         date = String.format("%04d-%02d-%02d", c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1,
               c.get(Calendar.DAY_OF_MONTH));
      }

      // 영화진흥원 API에 전달할 날짜 형식은 yyyymmdd이므로 준비된 날짜 문자열에서 "-"를 제거한다.
      String targetDt = date.replace("-", "");

      // 영화진흥원 OpenAPI를 통해 검색결과 받아오기
      Call<SearchDailyBoxOfficeList> call = kobisService.getsearchDailyBoxOfficeList(targetDt);
      SearchDailyBoxOfficeList searchDailyBoxOfficeList = null;
      try {
         searchDailyBoxOfficeList = call.execute().body();
      } catch (Exception e) {
         e.printStackTrace();
      }

      // 변수명이 너무 길어서 별도로 참조변수를 만들었다.
      List<DailyBoxOfficeList> list = null;

      // 검색 결과가 있다면 list만 추출한다.
      if (searchDailyBoxOfficeList != null) {
         list = searchDailyBoxOfficeList.getBoxOfficeResult().getDailyBoxOfficeList();
      }

      // View에게 변수를 전달하기 위한 값들을 Model 객체에 담는다.
      model.addAttribute("date", date);
      model.addAttribute("targetDt", targetDt);
      model.addAttribute("list", list);

      // View 경로 지정
      return "retrofit/daily_box_office";
   }

   @RequestMapping(value = "/retrofit/daily_box_office_graph.do", method = RequestMethod.GET)
   public String dailyBoxOfficeGraph(Model model) {
      // Retrofit 객체 생성
      Retrofit retrofit = retrofitHelper.getRetrofit(KobisService.BASE_URL);

      // Service 객체를 생성한다. 구현체는 Retrofit이 자동으로 생성해 준다.
      KobisService kobisService = retrofit.create(KobisService.class);

      // 검색일 파라미터 (yyyy-mm-dd 형식)
      String date = webHelper.getString("date");

      // 검색어가 없다면 calendar 클래스를 사용하여 하루 전 날 짜 값을 yyyy-mm-dd 형식으로 생성한다.
      if (date == null) {
         Calendar c = Calendar.getInstance();
         c.add(Calendar.DAY_OF_MONTH, -1);

         date = String.format("%04d-%02d-%02d", c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1,
               c.get(Calendar.DAY_OF_MONTH));
      }

      // 영화진흥원 API에 전달할 날짜 형식은 yyyymmdd이므로 준비된 날짜 문자열에서 "-"를 제거한다.
      String targetDt = date.replace("-", "");

      // 영화진흥원 OpenAPI를 통해 검색결과 받아오기
      Call<SearchDailyBoxOfficeList> call = kobisService.getsearchDailyBoxOfficeList(targetDt);
      SearchDailyBoxOfficeList searchDailyBoxOfficeList = null;
      try {
         searchDailyBoxOfficeList = call.execute().body();
      } catch (Exception e) {
         e.printStackTrace();
      }

      // 변수명이 너무 길어서 별도로 참조변수를 만들었다.
      List<DailyBoxOfficeList> list = null;

      // 검색 결과가 있다면 list만 추출한다.
      if (searchDailyBoxOfficeList != null) {
         list = searchDailyBoxOfficeList.getBoxOfficeResult().getDailyBoxOfficeList();
      }

      /** 프래프 출력을 위한 JS 코드에서 사용할 문자열 만들기 */
      int size = list.size(); // 리스트의 길이 저장
      String[] audiCnt = new String[size]; // 관람객 수를 저장할 배열
      String[] movieNm = new String[size]; // 영화 제목을 저장할 배열

      for (int i = 0; i < size; i++) { // 길이만큼 반복
         DailyBoxOfficeList item = list.get(i); // List에서 i번째 항목 추출
         movieNm[i] = "'" + item.getMovieNm() + "'"; // 영화제목을 배열에 원소로 저장
         audiCnt[i] = String.valueOf(item.getAudiCnt()); // 관람객수를 배열에 원소로 저장
      }

      String movieNmStr = String.join(",", movieNm); // 영화제목 배열을 콤마(,)를 기준으로 문자열로 연결
      String audiCntStr = String.join(",", audiCnt); // 관람객수 배열을 콤마(,)를 기준으로 문자열로 연결

      // View에게 변수를 전달하기 위한 값들을 Model 객체에 담는다.
      model.addAttribute("date", date);
      model.addAttribute("targetDt", targetDt);
      model.addAttribute("movieNmStr", movieNmStr);
      model.addAttribute("audiCntStr", audiCntStr);

      // View 경로 지정
      return "retrofit/daily_box_office_graph";
   }
}