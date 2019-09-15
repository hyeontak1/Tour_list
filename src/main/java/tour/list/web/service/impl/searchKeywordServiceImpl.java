package tour.list.web.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tour.list.web.model.searchKeyword;
import tour.list.web.service.searchKeywordService;

@Slf4j
@Service
public class searchKeywordServiceImpl implements searchKeywordService{

	@Autowired
	SqlSession sqlSession;
	
	public searchKeywordServiceImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 데이터 상세 조회
	@Override
	public searchKeyword getSearchKeywordItem(searchKeyword input) throws Exception {
		searchKeyword result = null;
		try {
			result = sqlSession.selectOne("searchKeywordMapper.selectItem", input);
			if(result == null) {
				throw new NullPointerException("result=null");
			}
		} catch(NullPointerException e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}
		return result;
	}

	// 데이터 목록 조회
	@Override
	public List<searchKeyword> getSearchKeywordList(searchKeyword input) throws Exception {
		List<searchKeyword> result = null;
		try {
			result = sqlSession.selectList("searchKeywordMapper.selectList", input);
			if(result == null) {
				throw new NullPointerException("result=null");
			}
		} catch(NullPointerException e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}
		return result;
	}

	// 데이터 갯수 조회
	@Override
	public int getSearchKeywordCount(searchKeyword input) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("searchKeywordMapper.selectCount", input);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}
		return result;
	}

	// 데이터 등록하기
	@Override
	public int addSearchKeyword(searchKeyword input) throws Exception {
		int result = 0;
		try {
			result = sqlSession.insert("searchKeywordMapper.insertItem", input);
			if(result == 0) {
				throw new NullPointerException("result=0");
			}
		} catch(NullPointerException e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 저장에 실패했습니다.");
		}
		return result;
	}

	// 데이터 수정하기
	@Override
	public int editSearchKeyword(searchKeyword input) throws Exception {
		int result = 0;
		try {
			result = sqlSession.update("searchKeywordMapper.updateItem", input);
			if(result == 0) {
				throw new NullPointerException("result=0");
			}
		} catch(NullPointerException e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("수정된 데이터가 없습니다.");
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 수정에 실패했습니다.");
		}
		return result;
	}

	// 데이터 삭제하기
	@Override
	public int deleteSearchKeyword(searchKeyword input) throws Exception {
		int result = 0;
		try {
			result = sqlSession.delete("searchKeywordMapper.deleteItem", input);
			if (result == 0) {
				throw new NullPointerException("result=0");
			}
		} catch(NullPointerException e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("삭제된 데이터가 없습니다.");
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 삭제에 실패했습니다.");
		}
		return result;
	}

}
