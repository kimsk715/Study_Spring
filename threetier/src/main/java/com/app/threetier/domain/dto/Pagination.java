package com.app.threetier.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@NoArgsConstructor
@Slf4j
public class Pagination {
    private int page;
    private int pageCount;
    private int startPage;
    private int endPage;
    private int rowCount;
    private int startRow;
    private int endRow;
    private int realEnd;
    private boolean prev, next;

    private String order;

    private String[] categories;
    private String keyword;

    public void create(int total) {
        this.rowCount = 10;
        this.pageCount = 10;

        this.page = page == 0 ? 1 : page;
        this.endPage = (int)(Math.ceil(this.page / (double)pageCount)) * pageCount;
        this.startPage = endPage - (pageCount - 1);
        this.realEnd = (int)Math.ceil(total / (double)rowCount);
        this.endPage = this.endPage > realEnd ? realEnd : endPage;
        this.endPage = this.endPage == 0 ? 1 : this.endPage;

        this.endRow = rowCount * this.page;
        this.startRow = endRow - (rowCount - 1);
        this.prev = startPage > 1;
        this.next = realEnd != endPage;
    }
}
