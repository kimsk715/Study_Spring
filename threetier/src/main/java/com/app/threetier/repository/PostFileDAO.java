package com.app.threetier.repository;

import com.app.threetier.domain.dto.PostFileDTO;
import com.app.threetier.domain.vo.FileVO;
import com.app.threetier.domain.vo.PostFileVO;
import com.app.threetier.mapper.FileMapper;
import com.app.threetier.mapper.PostFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostFileDAO {
    private final PostFileMapper postFileMapper;
    
//    추가하기
    public void save(PostFileVO postFileVO){
        postFileMapper.insert(postFileVO);
    }

//    파일 조회
    public List<PostFileDTO> selectByPostId(Long postId){
        return postFileMapper.selectByPostId(postId);
    }
//    파일 삭제
    public void delete(Long postId){
        postFileMapper.delete(postId);
    }

//    파일 삭제(아이디로)
    public void deleteById(Long postId){
        postFileMapper.deleteById(postId);
    }

//    파일 조회(아이디들로)
    public List<PostFileDTO> findAllById(Long[] arIdToDelete){
        return postFileMapper.selectAllById(arIdToDelete);
    }
}
