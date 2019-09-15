package tour.list.web.service;

import java.util.List;

public interface detailCommon {

	 /**
     * 데이터 상세 조회
     */
    public detailCommon getDetailCommonItem(detailCommon input) throws Exception;
    
    /**
     * 데이터 목록 조회
     */
    public List<detailCommon> getDetailCommonList(detailCommon input) throws Exception;
    
    /**
     * 데이터가 저장되어 있는 갯수 조회
     */
    public int getDetailCommonCount(detailCommon input) throws Exception;
    
    /**
     * 데이터 등록하기
     */
    public int addDetailCommon(detailCommon input) throws Exception;
    
    /**
     * 데이터 수정하기
     */
    public int editDetailCommon(detailCommon input) throws Exception;
    
    /**
     * 데이터 삭제하기
     */
    public int DeletedetailCommon(detailCommon input) throws Exception;
}
