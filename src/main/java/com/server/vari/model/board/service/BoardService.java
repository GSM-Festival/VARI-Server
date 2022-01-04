package com.server.vari.model.board.service;

import com.server.vari.model.board.Board;
import com.server.vari.model.board.dto.*;
import com.server.vari.model.board.enumType.BoardType;

import java.util.List;

public interface BoardService {

    Board createBoard(BoardDto boardDto);
    List<Board> findBoardByProjectType(BoardType boardType);
}
