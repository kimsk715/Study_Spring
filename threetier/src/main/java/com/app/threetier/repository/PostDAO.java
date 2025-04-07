package com.app.threetier.repository;

import com.app.threetier.domain.dto.Pagination;
import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.dto.PostFileDTO;
import com.app.threetier.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

//    전체 조회
    public List<PostDTO> findAll(Pagination pagination){
        return postMapper.selectAll(pagination);
    }

//    전체 개수
    public int findTotal(Pagination pagination){
        return postMapper.selectTotal(pagination);
    }

//    조회(아이디)
    public Optional<PostDTO> findById(Long id){
        return postMapper.selectById(id);
    }
//    조회수 증가
    public void setReadCount(Long id){
        postMapper.updateReadCount(id);
    }

//    게시글 등록
    public void save(PostDTO postDTO){
        postMapper.insert(postDTO);
    }

//    게시글 수정
    public void setPost(PostDTO postDTO){
        postMapper.update(postDTO);
    }

//    게시글 삭제
    public void delete(Long id){
        postMapper.delete(id);
    }
}
