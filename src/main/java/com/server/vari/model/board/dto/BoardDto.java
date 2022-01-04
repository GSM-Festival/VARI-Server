package com.server.vari.model.board.dto;

import com.server.vari.model.board.Board;
import com.server.vari.model.board.enumType.BoardType;
import com.server.vari.model.member.Member;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class BoardDto {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private BoardType boardType;

    public Board toEntity(BoardDto boardDto, Member member) {
        return Board.builder()
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .boardType(boardDto.getBoardType())
                .member(member)
                .build();
    }
}
