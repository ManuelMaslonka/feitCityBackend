package sk.uniza.feit.blog.mapper;

import sk.uniza.feit.blog.domain.PageList;
import sk.uniza.feit.site.rest.dto.PageListPostDto;

import java.util.List;

public class PageListMapper {

    private PageListMapper() {}

    public static PageListPostDto getPageListPostDto(PageList pageList) {
        PageListPostDto pageListPostDto = new PageListPostDto();
        pageListPostDto.setContent((List) pageList.content());
        pageListPostDto.totalCount(pageList.totalCount());
        pageListPostDto.summaryRow(pageList.summaryRow().toString());
        return pageListPostDto;
    }

}
