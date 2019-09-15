package tour.list.web.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tour.list.web.model.boardComment;
import tour.list.web.service.boardCommentService;

@Slf4j
@Service
public class boardCommentServiceImpl implements boardCommentService{
	
	@Autowired
	SqlSession sqlSession;
	
	public boardCommentServiceImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 데이터 상세 조회
	@Override
	public boardComment getBoardCommentItem(boardComment input) throws Exception {
		boardComment result = null;
		try {
			result = sqlSession.selectOne("boardCommentMapper.selectItem", input);
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
	public List<boardComment> getBoardCommentList(boardComment input) throws Exception {
		List<boardComment> result = null;
		try {
			result = sqlSession.selectList("boardCommentMapper.selectList", input);
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
	public int getBoardCommentCount(boardComment input) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("boardCommentMapper.selectCount", input);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}
		return result;
	}

	// 데이터 등록하기
	@Override
	public int addBoardComment(boardComment input) throws Exception {
		int result = 0;
		try {
			result = sqlSession.insert("boardCommentMapper.insertItem", input);
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
	public int editBoardComment(boardComment input) throws Exception {
		int result = 0;
		try {
			result = sqlSession.update("boardCommentMapper.updateItem", input);
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
	public int deleteBoardComment(boardComment input) throws Exception {
		int result = 0;
		try {
			result = sqlSession.delete("boarCommentdMapper.deleteItem", input);
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
