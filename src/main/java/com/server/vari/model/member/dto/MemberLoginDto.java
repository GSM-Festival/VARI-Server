package com.server.vari.model.member.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberLoginDto {

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
