package com.server.vari.model.member.controller;

import com.server.vari.model.member.dto.MemberDto;
import com.server.vari.model.member.dto.MemberLoginDto;
import com.server.vari.model.member.service.MemberService;
import com.server.vari.response.CommonResult;
import com.server.vari.response.SingleResult;
import com.server.vari.response.service.ResponseService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final ResponseService responseService;

    @PostMapping("/signup")
    @ApiOperation(value="회원가입")
    public CommonResult signup(@Valid @RequestBody MemberDto memberDto){
        memberService.signup(memberDto);
        return responseService.getSuccessResult();
    }

    @PostMapping("/signin")
    @ApiOperation(value="로그인")
    public SingleResult<Map<String, String>> signin(@Valid @RequestBody MemberLoginDto loginDto){
        Map<String, String> data = memberService.signin(loginDto);
        return responseService.getSingleResult(data);
    }

}
