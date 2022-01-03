package com.server.vari.model.request.dto;

import com.server.vari.model.board.Board;
import com.server.vari.model.request.Request;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RequestDto {

    @NotBlank
    private String stdNum;

    @NotBlank
    private String language;

    @NotBlank
    private String content;

    public Request toEntity(String stdNum, String language, String content, Board board) {
        return Request.builder()
                .stdNum(stdNum)
                .language(language)
                .content(content)
                .board(board)
                .build();
    }

}
