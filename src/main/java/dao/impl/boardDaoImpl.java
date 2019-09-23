package dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import dao.boardDao;
import tour.list.web.model.board;

public class boardDaoImpl implements boardDao{
	
	private static final String NAMESPACE = "com.doubles.mvcboard.mappers.board.boardMapper";
	
	private final SqlSession sqlSession;
	
	@Inject
	public boardDaoImpl(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	@Override
	public void create(board board) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE+".create",board);
	}

	@Override
	public board read(Integer idBoard) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".read",idBoard);
	}

	@Override
	public void update(board board) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE+".update",board);
	}

	@Override
	public void delete(Integer idBoard) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(NAMESPACE+".delete",idBoard);
	}

	@Override
	public List<board> listAll() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".listAll");
	}
	
}
