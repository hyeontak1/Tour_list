package dao;

import java.util.List;

import tour.list.web.model.board;

public interface boardDao {
	void create(board board) throws Exception;
	
	board read(Integer idBoard) throws Exception;
	
	void update(board board) throws Exception;
	
	void delete(Integer idBoard) throws Exception;
	
	List<board> listAll() throws Exception;
}
