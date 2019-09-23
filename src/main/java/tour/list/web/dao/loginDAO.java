package tour.list.web.dao;

import javax.servlet.http.HttpSession;

import tour.list.web.model.member;

public interface loginDAO {
	// 로그인 체크
	public boolean loginCheck(member vo);
	// 로그인 정보
	public member viewMember(member vo);
	// 로그아웃
	public void logout(HttpSession session);
}
