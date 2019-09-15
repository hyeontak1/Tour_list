package tour.list.web.service;

import java.util.List;

import tour.list.web.model.member;

public interface memberService {

	 /**
     * 데이터 상세 조회
     */
    public member getMemberItem(member input) throws Exception;
    
    /**
     * 데이터 목록 조회
     */
    public List<member> getMemberList(member input) throws Exception;
    
    /**
     * 데이터가 저장되어 있는 갯수 조회
     */
    public int getMemberCount(member input) throws Exception;
    
    /**
     * 데이터 등록하기
     */
    public int addMember(member input) throws Exception;
    
    /**
     * 데이터 수정하기
     */
    public int editMember(member input) throws Exception;
    
    /**
     * 데이터 삭제하기
     */
    public int deleteMember(member input) throws Exception;
}
