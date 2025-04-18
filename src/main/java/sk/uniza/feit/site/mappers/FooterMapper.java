package sk.uniza.feit.site.mappers;

import org.mapstruct.*;
import sk.uniza.feit.site.domain.components.models.Footer;
import sk.uniza.feit.site.rest.dto.FooterDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.SPRING)
public interface FooterMapper {
    Footer toEntity(FooterDto footerDto);

    FooterDto toDto(Footer footer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Footer partialUpdate(FooterDto footerDto,
                         @MappingTarget Footer footer);
}
