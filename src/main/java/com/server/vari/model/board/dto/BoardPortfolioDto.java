package com.server.vari.model.board.dto;

import com.server.vari.model.board.Board;
import com.server.vari.model.board.enumType.BoardType;
import com.server.vari.model.member.Member;

import javax.validation.constraints.NotBlank;

public class BoardDto {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    public Board toEntity(String title, String content, Member member) {
        return Board.builder()
                .title(title)
                .content(content)
                .member(member)
                .boardType(BoardType.PORTFOLIO)
                .build();
    }
}
