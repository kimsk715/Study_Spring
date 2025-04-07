package com.app.threetier.controller;

import com.app.threetier.domain.dto.Pagination;
import com.app.threetier.domain.dto.ReplyDTO;
import com.app.threetier.domain.dto.ReplyListDTO;
import com.app.threetier.domain.vo.ReplyVO;
import com.app.threetier.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/replies/*")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

//    추가
    @PostMapping("write")
    public void write(@RequestBody ReplyDTO replyDTO){
        replyService.write(replyDTO);
    }

//    목록
    @GetMapping("{postId}/{page}")
    public ReplyListDTO list(@PathVariable Long postId, @PathVariable int page){
        Pagination pagination = new Pagination();
        pagination.setPage(page);
        return replyService.getList(pagination, postId);
    }

//    수정
//    @PutMapping("{id}")
//    public void update(@RequestBody ReplyDTO replyDTO){}
    @PutMapping("update")
    public void update(@RequestBody ReplyDTO replyDTO){
        replyService.update(replyDTO);
    }

//    삭제
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        replyService.delete(id);
    }
}













