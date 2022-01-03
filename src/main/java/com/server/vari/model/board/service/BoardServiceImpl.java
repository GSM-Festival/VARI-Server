package com.server.vari.model.board.service;

import com.server.vari.model.board.Board;
import com.server.vari.model.board.dto.BoardContestDto;
import com.server.vari.model.board.dto.BoardPortfolioDto;
import com.server.vari.model.board.dto.BoardProjectDto;
import com.server.vari.model.board.dto.BoardStudyDto;
import com.server.vari.model.board.repository.BoardRepository;
import com.server.vari.model.member.Member;
import com.server.vari.util.CurrentUserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    private final CurrentUserUtil currentUserUtil;

    @Override
    public Board createBoardForPortfolio(BoardPortfolioDto boardPortfolioDto) {
        Member currentUser = currentUserUtil.getCurrentUser();

        Board board = boardRepository.save(boardPortfolioDto.toEntity(boardPortfolioDto.getTitle(), boardPortfolioDto.getContent(), currentUser));
        return board;
    }

    @Override
    public Board createBoardForProject(BoardProjectDto boardProjectDto) {
        Member currentUser = currentUserUtil.getCurrentUser();

        Board board = boardRepository.save(boardProjectDto.toEntity(boardProjectDto.getTitle(), boardProjectDto.getContent(), currentUser));
        return board;
    }

    @Override
    public Board createBoardForStudy(BoardStudyDto boardStudyDto) {
        Member currentUser = currentUserUtil.getCurrentUser();

        Board board = boardRepository.save(boardStudyDto.toEntity(boardStudyDto.getTitle(), boardStudyDto.getContent(), currentUser));
        return board;
    }

    @Override
    public Board createBoardForContest(BoardContestDto boardContestDto) {
        Member currentUser = currentUserUtil.getCurrentUser();

        Board board = boardRepository.save(boardContestDto.toEntity(boardContestDto.getTitle(), boardContestDto.getContent(), currentUser));
        return board;
    }

    @Override
    public List<Board> findAllBoard() {
        return boardRepository.findAll();
    }
}
