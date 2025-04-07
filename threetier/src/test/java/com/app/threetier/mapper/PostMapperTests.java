package com.app.threetier.mapper;

import com.app.threetier.domain.dto.Pagination;
import com.app.threetier.domain.dto.PostDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostMapperTests {
    @Autowired
    private PostMapper postMapper;

    @Test
    public void testSelectAll(){
        Pagination pagination = new Pagination();
        pagination.setPage(1);
        pagination.create(postMapper.selectTotal(pagination));
        postMapper.selectAll(pagination).stream().map(PostDTO::toString).forEach(log::info);
    }

}
