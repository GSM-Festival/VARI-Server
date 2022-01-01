package com.server.vari.model.member.service;

import com.server.vari.model.member.dto.MemberDto;
import com.server.vari.model.member.dto.MemberLoginDto;

import java.util.Map;

public interface MemberService {

    Long signup(MemberDto memberDto);
    Map<String, String> signin(MemberLoginDto LoginDto);

}
