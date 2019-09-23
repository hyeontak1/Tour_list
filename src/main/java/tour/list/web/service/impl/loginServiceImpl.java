package tour.list.web.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tour.list.web.dao.loginDAO;
import tour.list.web.model.member;
import tour.list.web.service.loginService;

@Service // 현재 클래스를 스프링에서 관리하는 service bean으로 등록
public class loginServiceImpl implements loginService{

	@Autowired
	loginDAO loginDao;
	
	// 로그인 체크
	@Override
	public boolean loginCheck(member vo, HttpSession session) {
		boolean result = loginDao.loginCheck(vo);
		if(result) { // true일 경우 세션에 등록
			member vo2 = viewMember(vo);
			// 세션 변수 등록
			session.setAttribute("id", vo2.getId());
			session.setAttribute("password", vo2.getPassword());
		}
		return result;
	}

	// 로그인 정보
	@Override
	public member viewMember(member vo) {
		return loginDao.viewMember(vo);
	}

	// 로그아웃
	@Override
	public void logout(HttpSession session) {
		// 세션 변수 개별 삭제
		// session.removeAttribute("id");
		// 세션 정보를 초기화 시킴
		session.invalidate();
	}


}
