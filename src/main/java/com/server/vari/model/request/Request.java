package com.server.vari.model.request;

import com.server.vari.model.board.Board;
import com.server.vari.model.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.*;

@Entity @Table(name = "REQUEST")
@Getter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Request {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "request_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @Column(name = "request_std_num", nullable = false)
    private String stdNum;

    @Column(name = "request_language", nullable = false)
    private String language;

    @Column(name = "request_content", nullable = false)
    private String content;

}
