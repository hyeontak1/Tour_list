package tour.list.web.service;

import java.util.List;

import tour.list.web.model.searchFestival;

public interface searchFestivalService {
	 /**
     * 데이터 상세 조회
     */
    public searchFestival getSearchFestivalItem(searchFestival input) throws Exception;
    
    /**
     * 데이터 목록 조회
     */
    public List<searchFestival> getSearchFestivalList(searchFestival input) throws Exception;
    
    /**
     * 데이터가 저장되어 있는 갯수 조회
     */
    public int getSearchFestivalCount(searchFestival input) throws Exception;
    
    /**
     * 데이터 등록하기
     */
    public int addSearchFestival(searchFestival input) throws Exception;
    
    /**
     * 데이터 수정하기
     */
    public int editSearchFestival(searchFestival input) throws Exception;
    
    /**
     * 데이터 삭제하기
     */
    public int deleteSearchFestival(searchFestival input) throws Exception;
}
