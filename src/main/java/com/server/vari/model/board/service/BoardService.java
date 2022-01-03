package com.server.vari.model.board.service;

import com.server.vari.model.board.Board;
import com.server.vari.model.board.dto.BoardContestDto;
import com.server.vari.model.board.dto.BoardPortfolioDto;
import com.server.vari.model.board.dto.BoardProjectDto;
import com.server.vari.model.board.dto.BoardStudyDto;

import java.util.List;

public interface BoardService {

    Board createBoardForPortfolio(BoardPortfolioDto boardPortfolioDto);
    Board createBoardForProject(BoardProjectDto boardProjectDto);
    Board createBoardForStudy(BoardStudyDto boardStudyDto);
    Board createBoardForContest(BoardContestDto boardContestDto);
    List<Board> findAllBoard();
}
