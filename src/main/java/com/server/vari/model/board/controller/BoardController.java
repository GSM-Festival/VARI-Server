package com.server.vari.model.board.controller;

import com.server.vari.model.board.Board;
import com.server.vari.model.board.dto.BoardContestDto;
import com.server.vari.model.board.dto.BoardPortfolioDto;
import com.server.vari.model.board.dto.BoardProjectDto;
import com.server.vari.model.board.dto.BoardStudyDto;
import com.server.vari.model.board.service.BoardService;
import com.server.vari.response.CommonResult;
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
    @ApiOperation(value = "게시판 전체 조회", notes = "게시판 전체 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "RefreshToken", value = "로그인 성공 후 refresh_token", required = false, dataType = "String", paramType = "header")
    })
    public SingleResult findAllBoard() {
        List<Board> allBoard = boardService.findAllBoard();
        return responseService.getSingleResult(allBoard);
    }

    @PostMapping("/board/create-portfolio")
    @ResponseStatus( HttpStatus.CREATED )
    @ApiOperation(value = "게시판 작성", notes = "게시판 작성")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "RefreshToken", value = "로그인 성공 후 refresh_token", required = false, dataType = "String", paramType = "header")
    })
    public CommonResult createBoardPortfolio(@Valid @RequestBody BoardPortfolioDto portfolioDto) {
        boardService.createBoardForPortfolio(portfolioDto);
        return responseService.getSuccessResult();
    }

    @PostMapping("/board/create-project")
    @ResponseStatus( HttpStatus.CREATED )
    @ApiOperation(value = "게시판 작성", notes = "게시판 작성")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "RefreshToken", value = "로그인 성공 후 refresh_token", required = false, dataType = "String", paramType = "header")
    })
    public CommonResult createBoardProject(@Valid @RequestBody BoardProjectDto boardProjectDto) {
        boardService.createBoardForProject(boardProjectDto);
        return responseService.getSuccessResult();
    }

    @PostMapping("/board/create-study")
    @ResponseStatus( HttpStatus.CREATED )
    @ApiOperation(value = "게시판 작성", notes = "게시판 작성")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "RefreshToken", value = "로그인 성공 후 refresh_token", required = false, dataType = "String", paramType = "header")
    })
    public CommonResult createBoardStudy(@Valid @RequestBody BoardStudyDto boardStudyDto) {
        boardService.createBoardForStudy(boardStudyDto);
        return responseService.getSuccessResult();
    }

    @PostMapping("/board/create-contest")
    @ResponseStatus( HttpStatus.CREATED )
    @ApiOperation(value = "게시판 작성", notes = "게시판 작성")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "RefreshToken", value = "로그인 성공 후 refresh_token", required = false, dataType = "String", paramType = "header")
    })
    public CommonResult createBoardContest(@Valid @RequestBody BoardContestDto boardContestDto) {
        boardService.createBoardForContest(boardContestDto);
        return responseService.getSuccessResult();
    }



}
