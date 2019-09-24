package tour.list.web.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tour.list.web.model.member;
import tour.list.web.service.loginService;

@Slf4j
@Service
public class loginServiceImpl implements loginService{

	@Autowired
	SqlSession sqlSession;
	
	public loginServiceImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public member login(member input) throws Exception {
		member result = null;
		try {
		result = sqlSession.selectOne("memberMapper.login", input);
		if(result == null) {
			throw new NullPointerException("result=null");
		}
		}catch(NullPointerException e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("아이디 또는 비밀번호가 다릅니다.");
		}catch(Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}
		return result;
	}

}
