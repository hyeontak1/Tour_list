package tour.list.web;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import retrofit2.Call;
import retrofit2.Retrofit;
import tour.list.web.helper.RetrofitHelper;
import tour.list.web.helper.WebHelper;
import tour.list.web.model.detailCommonApi;
import tour.list.web.model.searchKeyword;
import tour.list.web.model.searchKeywordApi;
import tour.list.web.service.apiService;
import tour.list.web.service.detailCommonService;
import tour.list.web.service.detailImageService;
import tour.list.web.service.detailIntroService;
import tour.list.web.service.searchFestivalService;
import tour.list.web.service.searchKeywordService;
 
@Controller 
public class HomeController {
	
	@Autowired
	WebHelper webHelper;
	
	@Autowired
	RetrofitHelper retrofitHelper;
	
	@Autowired
	detailCommonService detailCommonService;
	
	@Autowired
	detailImageService detailImageService;
	
	@Autowired
	detailIntroService detailIntroService;
	
	@Autowired
	searchFestivalService searchFestivalService;
	
	@Autowired
	searchKeywordService searchKeywordService;
	
	@RequestMapping(value = "/tour_list/db.do", method = RequestMethod.POST)
	public ModelAndView db(Model model) {
		
		Retrofit retrofit = retrofitHelper.getRetrofit(apiService.BASE_URL);
		
		apiService apiService = retrofit.create(apiService.class);
		
		// 키워드api 받아오기
		String keyword = webHelper.getString("관광지");
		Call<searchKeywordApi> call = apiService.getsearchKeywordApi(keyword);
		searchKeywordApi searchKeywordApi = null;
		try {
			searchKeywordApi = call.execute().body();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 키워드 db저장
		
	
		
		
		String viewPath = "tour_list/db";
		return new ModelAndView(viewPath);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
