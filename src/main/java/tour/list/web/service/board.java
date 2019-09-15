package tour.list.web.service;

import java.util.List;

public interface board {

	 /**
     * 데이터 상세 조회
     */
    public board getBoardItem(board input) throws Exception;
    
    /**
     * 데이터 목록 조회
     */
    public List<board> getBoardList(board input) throws Exception;
    
    /**
     * 데이터가 저장되어 있는 갯수 조회
     */
    public int getBoardCount(board input) throws Exception;
    
    /**
     * 데이터 등록하기
     */
    public int addBoard(board input) throws Exception;
    
    /**
     * 데이터 수정하기
     */
    public int editBoard(board input) throws Exception;
    
    /**
     * 데이터 삭제하기
     */
    public int deleteBoard(board input) throws Exception;

}
