package tour.list.web.service;

import java.util.List;

public interface searchKeyword {

	 /**
     * 데이터 상세 조회
     */
    public searchKeyword getSearchKeywordItem(searchKeyword input) throws Exception;
    
    /**
     * 데이터 목록 조회
     */
    public List<searchKeyword> getSearchKeywordList(searchKeyword input) throws Exception;
    
    /**
     * 데이터가 저장되어 있는 갯수 조회
     */
    public int getSearchKeywordCount(searchKeyword input) throws Exception;
    
    /**
     * 데이터 등록하기
     */
    public int addSearchKeyword(searchKeyword input) throws Exception;
    
    /**
     * 데이터 수정하기
     */
    public int editSearchKeyword(searchKeyword input) throws Exception;
    
    /**
     * 데이터 삭제하기
     */
    public int deleteSearchKeyword(searchKeyword input) throws Exception;
}
