package tour.list.web.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tour.list.web.model.board;
import tour.list.web.service.boardService;

@Slf4j
@Service
public class boardServiceImpl implements boardService{
	
	@Autowired
	SqlSession sqlSession;
	
	public boardServiceImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 데이터 상세 조회
	@Override
	public board getBoardItem(board input) throws Exception {
		board result = null;
		try {
			result = sqlSession.selectOne("boardMapper.selectItem", input);
			if (result == null) {
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
	public List<board> getBoardList(board input) throws Exception {
		List<board> result = null;
		try {
			result = sqlSession.selectList("boardMapper.selectList", input);
			if (result == null) {
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
	public int getBoardCount(board input) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("boardMapper.selectCount", input);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}
		return result;
	}

	// 데이터 등록하기
	@Override
	public int addBoard(board input) throws Exception {
		int result = 0;
		try {
			result = sqlSession.insert("boardMapper.insertItem", input);
			if (result == 0) {
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
	public int editBoard(board input) throws Exception {
		int result = 0;
		try {
			result = sqlSession.update("boardMapper.updateItem", input);
			if (result == 0) {
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
	public int deleteBoard(board input) throws Exception {
		int result = 0;
		try {
			result = sqlSession.delete("boardMapper.deleteItem", input);
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
