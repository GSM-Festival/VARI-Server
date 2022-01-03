package com.server.vari.model.board.dto;

import com.server.vari.model.board.Board;
import com.server.vari.model.board.enumType.BoardType;
import com.server.vari.model.member.Member;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class BoardContestDto {
    @NotBlank
    private String title;

    @NotBlank
    private String content;

    public Board toEntity(String title, String content, Member member) {
        return Board.builder()
                .title(title)
                .content(content)
                .member(member)
                .boardType(BoardType.CONTEST)
                .build();
    }
}
