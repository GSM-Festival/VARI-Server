package com.server.vari.model.board.repository;

import com.server.vari.model.board.Board;
import com.server.vari.model.board.enumType.BoardType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAllByBoardType(BoardType boardType);

}
