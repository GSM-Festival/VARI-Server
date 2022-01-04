package com.server.vari.model.board.service;

import com.server.vari.model.board.Board;
import com.server.vari.model.board.dto.*;
import com.server.vari.model.board.enumType.BoardType;
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
    public Board createBoard(BoardDto boardDto) {
        Member currentUser = currentUserUtil.getCurrentUser();

        Board board = boardRepository.save(boardDto.toEntity(boardDto, currentUser));
        return board;
    }

    @Override
    public List<Board> findBoardByProjectType(BoardType boardType) {
        return boardRepository.findAllByBoardType(boardType);
    }


}
