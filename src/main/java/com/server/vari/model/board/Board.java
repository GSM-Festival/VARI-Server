package com.server.vari.model.board;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.server.vari.model.board.enumType.BoardType;
import com.server.vari.model.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

@Entity @Table(name = "BOARD")
@Getter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Board {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Member member;

    @Column(name = "board_title", nullable = false)
    private String title;

    @Column(name = "board_content", nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "board_type", nullable = false)
    private BoardType boardType;
}
