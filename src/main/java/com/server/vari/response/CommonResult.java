package com.server.vari.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter @Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE) @AllArgsConstructor
public class CommonResult {
    @ApiModelProperty(value = "응답 성공여부")
    private boolean success;

    @ApiModelProperty(value = "응답 코드번호")
    private int code;

    @ApiModelProperty(value = "응답 메세지")
    private String msg;

    public CommonResult(CommonResult commonResult) {

    }
}
