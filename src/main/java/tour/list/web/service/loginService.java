package tour.list.web.service;

import javax.servlet.http.HttpSession;

import tour.list.web.model.member;

public interface loginService {
	//로그인 체크
	public boolean loginCheck(member vo, HttpSession session);
	// 로그인 정보
	public member viewMember(member vo);
	// 로그아웃
	public void logout(HttpSession sesison);
}
