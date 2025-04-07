package com.app.threetier.service;

import com.app.threetier.domain.dto.Pagination;
import com.app.threetier.domain.dto.ReplyDTO;
import com.app.threetier.domain.dto.ReplyListDTO;
import com.app.threetier.repository.ReplyDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class ReplyService {
    private final ReplyDAO replyDAO;

    public void write(ReplyDTO replyDTO){
        replyDAO.save(replyDTO.toVO());
    }

    public ReplyListDTO getList(Pagination pagination, Long postId){
        ReplyListDTO replyListDTO = new ReplyListDTO();

        pagination.create(replyDAO.findTotalByPostId(postId));

        replyListDTO.setPagination(pagination);
        replyListDTO.setReplies(replyDAO.findAllByPostId(pagination, postId));

        return replyListDTO;
    }

    public void update(ReplyDTO replyDTO){
        replyDAO.setReply(replyDTO.toVO());
    }

    public void delete(Long id){
        replyDAO.delete(id);
    }
}















