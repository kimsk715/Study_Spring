package com.app.threetier.repository;

import com.app.threetier.domain.dto.Pagination;
import com.app.threetier.domain.dto.ReplyDTO;
import com.app.threetier.domain.vo.ReplyVO;
import com.app.threetier.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReplyDAO {
    private final ReplyMapper replyMapper;

//    댓글 추가
    public void save(ReplyVO replyVO){
        replyMapper.insert(replyVO);
    }
//    댓글 목록
    public List<ReplyDTO> findAllByPostId(Pagination pagination, Long postId){
        return replyMapper.selectAllByPostId(pagination, postId);
    }

//    댓글 전체 개수(게시글 당)
    public int findTotalByPostId(Long postId){
        return replyMapper.selectTotalByPostId(postId);
    }
//    댓글 수정
    public void setReply(ReplyVO replyVO){
        replyMapper.update(replyVO);
    }

//    댓글 삭제
    public void delete(Long id){
        replyMapper.delete(id);
    }
}
