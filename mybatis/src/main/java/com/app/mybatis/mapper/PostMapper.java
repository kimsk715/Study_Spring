package com.app.mybatis.mapper;

import com.app.mybatis.domain.dto.PostDTO;
import com.app.mybatis.domain.vo.PostVO;
import com.app.mybatis.util.Pagination;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
//    추가
    public void insert(PostVO postVO);

//    목록
    public List<PostDTO> selectAll(Pagination pagination);

//    전체 개수
    public int selectTotal();

//    수정
    public void update(PostVO postVO);

//    삭제
    public void delete(Long id);

//    조회
    public Optional<PostDTO> selectById(Long id);
}















