package tour.list.web.service;

import java.util.List;

public interface detailImage {

	 /**
     * 데이터 상세 조회
     */
    public detailImage getDetailImageItem(detailImage input) throws Exception;
    
    /**
     * 데이터 목록 조회
     */
    public List<detailImage> getDetailImageList(detailImage input) throws Exception;
    
    /**
     * 데이터가 저장되어 있는 갯수 조회
     */
    public int getDetailImageCount(detailImage input) throws Exception;
    
    /**
     * 데이터 등록하기
     */
    public int addDetailImage(detailImage input) throws Exception;
    
    /**
     * 데이터 수정하기
     */
    public int editDetailImage(detailImage input) throws Exception;
    
    /**
     * 데이터 삭제하기
     */
    public int DeletedetailImage(detailImage input) throws Exception;
}
