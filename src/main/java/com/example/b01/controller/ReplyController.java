package com.example.b01.controller;

import com.example.b01.dto.PageRequestDTO;
import com.example.b01.dto.PageResponseDTO;
import com.example.b01.dto.ReplyDTO;
import com.example.b01.service.ReplyService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("replies")
@Log4j2
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @ApiOperation(value="Replies POST", notes = "POST 방식으로 댓글 등록")
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Long> register(
            @Valid @RequestBody ReplyDTO replyDTO,
            BindingResult bindingResult) throws BindException {
        log.info(replyDTO);
        if(bindingResult.hasErrors()){
            throw new BindException(bindingResult);
        }
        Map<String, Long> resultMap = new HashMap<>();

        Long rno = replyService.register(replyDTO);
        resultMap.put("rno", rno);

        return resultMap;
    }

    @ApiOperation(value="Replies of Board", notes = "GET 방식으로 특정게시물의 댓글 목록")
    @GetMapping (value = "/list/{bno}")

    public PageResponseDTO<ReplyDTO> getList(@PathVariable("bno") Long bno,
    PageRequestDTO pageRequestDTO) {

        PageResponseDTO<ReplyDTO> responseDTO = replyService.getListOfBoard(bno, pageRequestDTO);

        return responseDTO;
    }

    @ApiOperation(value="read Reply", notes = "GET 방식으로 특정 댓글 목록")
    @GetMapping (value = "/{rno}")
    public ReplyDTO getReplyDTO( @PathVariable("rno") Long rno) {
        ReplyDTO replyDTO = replyService.read(rno);

        return replyDTO;
    }

    @ApiOperation(value="Delete Reply", notes = "Delete 방식으로 특정 댓글 삭제")
    @DeleteMapping (value = "/{rno}")
    public Map<String, Long> remove( @PathVariable("rno") Long rno) {

        replyService.remove(rno);

        Map<String, Long> resultMap = new HashMap<>();

        resultMap.put("rno", rno);

        return resultMap;
    }


    @ApiOperation(value="Delete Reply", notes = "Put 방식으로 특정 댓글 수정")
    @PutMapping (value = "/{rno}")
    public Map<String, Long> remove( @PathVariable("rno") Long rno, @RequestBody ReplyDTO replyDTO) {

        replyDTO.setRno(rno);

        replyService.modify(replyDTO);

        Map<String, Long> resultMap = new HashMap<>();

        resultMap.put("rno", rno);

        return resultMap;
    }
}
