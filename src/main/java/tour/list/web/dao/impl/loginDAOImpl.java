package tour.list.web.dao.impl;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tour.list.web.dao.loginDAO;
import tour.list.web.model.member;

@Repository // 현재 클래스를 스프링에서 관리하는 dao bean으로 등록
public class loginDAOImpl implements loginDAO{

	@Autowired
	SqlSession sqlSession; // mybatis 실행 객체
	
	// 로그인 체크
	@Override
	public boolean loginCheck(member vo) {
		String name = sqlSession.selectOne("memberMapper.loginCheck", vo);
		return (name ==null) ? false : true;
	}

	// 로그인 정보
	@Override
	public member viewMember(member vo) {
		return sqlSession.selectOne("memberMapper.viewMember", vo);
	}

	// 로그아웃
	@Override
	public void logout(HttpSession session) {
	}

}
