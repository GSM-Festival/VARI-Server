package com.server.vari.model.member.service;

import com.server.vari.jwt.JwtTokenProvider;
import com.server.vari.model.member.Member;
import com.server.vari.model.member.dto.MemberDto;
import com.server.vari.model.member.dto.MemberLoginDto;
import com.server.vari.model.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public Long signup(MemberDto memberDto) {
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        Member member = memberDto.toEntity();
        memberRepository.save(member);

        return member.getId();
    }

    @Override
    public Map<String, String> signin(MemberLoginDto loginDto) {
        Member findUser = memberRepository.findByEmail(loginDto.getEmail());
        if(!passwordEncoder.matches(loginDto.getPassword(),findUser.getPassword())) throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");

        Map<String, String> map = new HashMap<>();
        String accessToken = jwtTokenProvider.createToken(findUser.getUsername(), findUser.getRoles()); // 유저정보에서 Username : 유저정보에서 Role (Key : Value)
        String refreshToken = jwtTokenProvider.createRefreshToken();

        findUser.updateRefreshToken(refreshToken);

        // map에 username, accessToken, refreshToken 정보 입력
        map.put("username", findUser.getUsername());
        map.put("accessToken","Bearer " + accessToken);
        map.put("refreshToken","Bearer " + refreshToken);

        return map;
    }
}
