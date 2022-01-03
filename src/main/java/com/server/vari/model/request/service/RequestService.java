package com.server.vari.model.request.service;

import com.server.vari.model.request.Request;
import com.server.vari.model.request.dto.RequestDto;

public interface RequestService {

    Request createRequest(RequestDto requestDto, Long id);

}