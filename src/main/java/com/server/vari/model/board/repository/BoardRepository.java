package com.server.vari.model.board.repository;

import com.server.vari.model.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
