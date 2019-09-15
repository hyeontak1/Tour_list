package tour.list.web.service;

import java.util.List;

import tour.list.web.model.detailIntro;

public interface detailIntroService {

	 /**
     * 데이터 상세 조회
     */
    public detailIntro getDetailIntroItem(detailIntro input) throws Exception;
    
    /**
     * 데이터 목록 조회
     */
    public List<detailIntro> getDetailIntroList(detailIntro input) throws Exception;
    
    /**
     * 데이터가 저장되어 있는 갯수 조회
     */
    public int getDetailIntroCount(detailIntro input) throws Exception;
    
    /**
     * 데이터 등록하기
     */
    public int addDetailIntro(detailIntro input) throws Exception;
    
    /**
     * 데이터 수정하기
     */
    public int editDetailIntro(detailIntro input) throws Exception;
    
    /**
     * 데이터 삭제하기
     */
    public int deleteDetailIntro(detailIntro input) throws Exception;
}
