package com.app.threetier.mapper;

import com.app.threetier.domain.dto.PostFileDTO;
import com.app.threetier.domain.vo.PostFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostFileMapper {
//    파일 추가
    public void insert(PostFileVO postFileVO);

//    파일 조회
    public List<PostFileDTO> selectByPostId(Long postId);

//    파일 삭제
    public void delete(Long postId);

//    파일 삭제(아이디로)
    public void deleteById(Long postId);

//    파일 조회(아이디들로)
    public List<PostFileDTO> selectAllById(Long[] arIdToDelete);
}
