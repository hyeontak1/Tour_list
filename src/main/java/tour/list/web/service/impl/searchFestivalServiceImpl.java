package tour.list.web.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tour.list.web.model.searchFestival;
import tour.list.web.service.searchFestivalService;

@Slf4j
@Service
public class searchFestivalServiceImpl implements searchFestivalService{

	@Autowired
	SqlSession sqlSession;
	
	public searchFestivalServiceImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 데이터 상세 조회
	@Override
	public searchFestival getSearchFestivalItem(searchFestival input) throws Exception {
		searchFestival result = null;
		try {
			result = sqlSession.selectOne("searchFestivalMapper.selectItem", input);
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
	public List<searchFestival> getSearchFestivalList(searchFestival input) throws Exception {
		List<searchFestival> result = null;
		try {
			result = sqlSession.selectList("searchFestivalMapper.selectList", input);
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
	public int getSearchFestivalCount(searchFestival input) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("searchFestivalMapper.selectCount", input);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}
		return result;
	}

	// 데이터 등록하기
	@Override
	public int addSearchFestival(searchFestival input) throws Exception {
		int result = 0;
		try {
			result = sqlSession.insert("searchFestivalMapper.insertItem", input);
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
	public int editSearchFestival(searchFestival input) throws Exception {
		int result = 0;
		try {
			result = sqlSession.update("searchFestivalMapper.updateItem", input);
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
	public int deleteSearchFestival(searchFestival input) throws Exception {
		int result = 0;
		try {
			result = sqlSession.delete("searchFestivalMapper.deleteItem", input);
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
