package tour.list.web.service;

import java.util.List;

import tour.list.web.model.board;

public interface boardService {

    public board getBoardItem(board input) throws Exception;
    
    
    public List<board> getBoardList(board input) throws Exception;
    
    
    public int getBoardCount(board input) throws Exception;
    
    /**
     * �뜲�씠�꽣 �벑濡앺븯湲�
     */
    public int addBoard(board input) throws Exception;
    
    /**
     * �뜲�씠�꽣 �닔�젙�븯湲�
     */
    public int editBoard(board input) throws Exception;
    
    /**
     * �뜲�씠�꽣 �궘�젣�븯湲�
     */
    public int deleteBoard(board input) throws Exception;

}
