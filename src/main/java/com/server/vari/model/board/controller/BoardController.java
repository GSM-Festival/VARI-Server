package com.server.vari.model.board.controller;

import com.server.vari.model.board.Board;
import com.server.vari.model.board.dto.*;
import com.server.vari.model.board.enumType.BoardType;
import com.server.vari.model.board.service.BoardService;
import com.server.vari.response.CommonResult;
import com.server.vari.response.ListResult;
import com.server.vari.response.SingleResult;
import com.server.vari.response.service.ResponseService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final ResponseService responseService;

    @GetMapping("/board")
    @ResponseStatus( HttpStatus.OK )
    @ApiOperation(value = "BoardType에 맞는 게시판 조회", notes = "BoardType에 맞는 게시판 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "RefreshToken", value = "로그인 성공 후 refresh_token", required = false, dataType = "String", paramType = "header")
    })
    public ListResult<Board> findAllBoard(BoardType boardType) {
        List<Board> board = boardService.findBoardByProjectType(boardType);
        return responseService.getListResult(board);
    }

    @PostMapping("/board/create")
    @ResponseStatus( HttpStatus.CREATED )
    @ApiOperation(value = "게시판 작성", notes = "게시판 작성")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "RefreshToken", value = "로그인 성공 후 refresh_token", required = false, dataType = "String", paramType = "header")
    })
    public CommonResult createBoard(@Valid @RequestBody BoardDto boardDto) {
        boardService.createBoard(boardDto);
        return responseService.getSuccessResult();
    }


}
