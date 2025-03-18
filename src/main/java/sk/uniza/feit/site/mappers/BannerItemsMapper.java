package sk.uniza.feit.site.mappers;

import org.mapstruct.*;
import sk.uniza.feit.site.domain.components.models.BannerItems;
import sk.uniza.feit.site.rest.dto.BannerItemsDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BannerItemsMapper {
    BannerItems toEntity(BannerItemsDto bannerItemsDto);

    BannerItemsDto toDto(BannerItems bannerItems);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    BannerItems partialUpdate(BannerItemsDto bannerItemsDto,
                              @MappingTarget BannerItems bannerItems);
}
