package com.server.vari.model.request.service;

import com.server.vari.model.board.Board;
import com.server.vari.model.board.repository.BoardRepository;
import com.server.vari.model.request.Request;
import com.server.vari.model.request.dto.RequestDto;
import com.server.vari.model.request.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RequestServiceImpl implements RequestService{

    private final BoardRepository boardRepository;
    private final RequestRepository requestRepository;

    @Override
    public Request createRequest(RequestDto requestDto, Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        return requestRepository.save(requestDto.toEntity(requestDto.getStdNum(), requestDto.getLanguage(), requestDto.getContent(), board));
    }
}
