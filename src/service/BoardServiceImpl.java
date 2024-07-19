package service;

import java.util.List;

import dao.BoardDaoImpl;
import dao.IBoardDao;
import vo.BoardVO;

public class BoardServiceImpl implements IBoardService {
	
	private IBoardDao boardDao;

	private static IBoardService boardService = new BoardServiceImpl();
	
	private BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance();
	}
	 
	public static IBoardService getInstance() {
		return boardService;
	}

	
	
	@Override
	public List<BoardVO> printAllSv(BoardVO bv) {
		return boardDao.printAll(bv );
	}

	@Override
	public int insertBoardSv(BoardVO bv) {
		return boardDao.insertBoard(bv);
	}

	@Override
	public int updateBoardSv(BoardVO bv) {
		return boardDao.updateBoard(bv);
	}

	@Override
	public int deleteBoardSv(BoardVO bv) {
		return boardDao.deleteBoard(bv);
	}

	@Override
	public List<BoardVO> searchBoardSv(BoardVO bv) {
		return boardDao.searchBoard(bv);
	}
	
	public List<BoardVO> dateSearchBoardSv(String param) {
		return boardDao.dateSearchBoard(param);
	}

}
