package sk.uniza.feit.site.mappers;

import org.mapstruct.*;
import sk.uniza.feit.site.domain.components.models.FaqComponent;
import sk.uniza.feit.site.rest.dto.FaqComponentDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.SPRING)
public interface FaqComponentMapper {
    FaqComponent toEntity(FaqComponentDto faqComponentDto);

    FaqComponentDto toDto(FaqComponent faqComponent);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FaqComponent partialUpdate(FaqComponentDto faqComponentDto,
                               @MappingTarget FaqComponent faqComponent);
}
