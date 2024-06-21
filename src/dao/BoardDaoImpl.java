package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import util.JDBCUtilHw10;
import vo.BoardVO;

public class BoardDaoImpl implements IBoardDao {

	private static IBoardDao boardDao = new BoardDaoImpl();
	
	private BoardDaoImpl() {
	}
	
	public static IBoardDao getInstance() {
		return boardDao;
	}


	@Override
	public int insertBoard(BoardVO bv) {
		SqlSession session = JDBCUtilHw10.getSqlSession();

		int cnt = 0;

		try {
			cnt = session.insert("Board.insertBoard", bv);

			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	
	@Override
	public int updateBoard(BoardVO bv) {
		SqlSession session = JDBCUtilHw10.getSqlSession();

		int cnt = 0;

		try {
			cnt = session.update("Board.updateBoard", bv);

			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	
	@Override
	public int deleteBoard(BoardVO bv) {
		SqlSession session = JDBCUtilHw10.getSqlSession();

		int cnt = 0;

		try {
			cnt = session.delete("Board.deleteBoard", bv);

			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}
	
	
	@Override
	public List<BoardVO> printAll(BoardVO bv) {
		SqlSession session = JDBCUtilHw10.getSqlSession(true);

		List<BoardVO> list = new ArrayList<BoardVO>();

		try {

			list = session.selectList("Board.printAllBoard", bv);

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}
	

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		SqlSession session = JDBCUtilHw10.getSqlSession(true);

		List<BoardVO> list = new ArrayList<BoardVO>();

		try {

			list = session.selectList("Board.searchBoard", bv);

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	
		public List<BoardVO> dateSearchBoard(String param) {
			SqlSession session = JDBCUtilHw10.getSqlSession(true);

			List<BoardVO> list = new ArrayList<BoardVO>();

			try {

				list = session.selectList("Board.dateSearch", param);

			} catch (PersistenceException e) {
				e.printStackTrace();
			} finally {
				session.close();
			}

			return list;
		}

}
