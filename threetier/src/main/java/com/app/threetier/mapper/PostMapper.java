package com.app.threetier.mapper;

import com.app.threetier.domain.dto.Pagination;
import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.MemberVO;
import com.app.threetier.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
//    전체 조회
    public List<PostDTO> selectAll(Pagination pagination);

//    전체 개수
    public int selectTotal(Pagination pagination);

//    조회(아이디)
    public Optional<PostDTO> selectById(Long id);

//    조회수 증가
    public void updateReadCount(Long id);

//    게시글 추가
    public void insert(PostDTO postDTO);

//    게시글 수정
    public void update(PostDTO postDTO);

//    게시글 삭제
    public void delete(Long id);
}


