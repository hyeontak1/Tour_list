package tour.list.web.service;

import java.util.List;

public interface boardComment {

	 /**
     * 데이터 상세 조회
     */
    public boardComment getBoardCommentItem(boardComment input) throws Exception;
    
    /**
     * 데이터 목록 조회
     */
    public List<boardComment> getBoardCommentList(boardComment input) throws Exception;
    
    /**
     * 데이터가 저장되어 있는 갯수 조회
     */
    public int getBoardCommentCount(boardComment input) throws Exception;
    
    /**
     * 데이터 등록하기
     */
    public int addBoardComment(boardComment input) throws Exception;
    
    /**
     * 데이터 수정하기
     */
    public int editBoardComment(boardComment input) throws Exception;
    
    /**
     * 데이터 삭제하기
     */
    public int deleteBoardComment(boardComment input) throws Exception;
}
