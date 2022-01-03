package com.server.vari.model.request.controller;

import com.server.vari.model.request.dto.RequestDto;
import com.server.vari.model.request.service.RequestService;
import com.server.vari.response.CommonResult;
import com.server.vari.response.service.ResponseService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;
    private final ResponseService responseService;

    @PostMapping("/request/{id}")
    @ResponseStatus( HttpStatus.CREATED )
    @ApiOperation(value = "신청서 작성", notes = "신청서 작성")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "RefreshToken", value = "로그인 성공 후 refresh_token", required = false, dataType = "String", paramType = "header")
    })
    public CommonResult createRequest(@RequestBody RequestDto requestDto, @PathVariable("id") Long id) {
        requestService.createRequest(requestDto, id);
        return responseService.getSuccessResult();
    }
}
