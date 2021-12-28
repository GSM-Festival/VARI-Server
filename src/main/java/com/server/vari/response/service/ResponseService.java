package com.server.vari.response.service;

import com.server.vari.response.CommonResult;
import com.server.vari.response.ListResult;
import com.server.vari.response.SingleResult;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    @Getter
    public enum CommonResponse {
        SUCCESS(0, "성공 하였습니다."),
        FAIL(-1, "실패 하였습니다.");

        int code;
        String msg;

        CommonResponse(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }

    // 요청 데이터가 없는 성공 결과 객체 반환
    public CommonResult getSuccessResult() {
        return CommonResult.builder()
                .success(true)
                .code(CommonResponse.SUCCESS.getCode())
                .msg(CommonResponse.SUCCESS.getMsg())
                .build();
    }

    // 단일건의 데이터가 있는 결과 객체 반환
    public <T> SingleResult<T> getSingleResult(T data){
        return new SingleResult<T>(getSuccessResult(), data);
    }

    // 다중값의 데이터가 있는 결과 객체 반환
    public <T> ListResult<T> getListResult(List<T> list){
        return new ListResult<T>(getSuccessResult(), list);
    }

    // 사용자 지정 실패 결과 객체 반환
    public CommonResult getFailResult(int code, String msg) {
        return CommonResult.builder()
                .success(false)
                .code(code)
                .msg(msg)
                .build();
    }

}
