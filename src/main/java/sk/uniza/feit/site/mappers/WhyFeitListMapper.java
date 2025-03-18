package sk.uniza.feit.site.mappers;

import org.mapstruct.*;
import sk.uniza.feit.site.domain.components.models.WhyFeitList;
import sk.uniza.feit.site.rest.dto.WhyFeitListDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface WhyFeitListMapper {
    WhyFeitList toEntity(WhyFeitListDto whyFeitListDto);

    WhyFeitListDto toDto(WhyFeitList whyFeitList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    WhyFeitList partialUpdate(WhyFeitListDto whyFeitListDto,
                              @MappingTarget WhyFeitList whyFeitList);
}
