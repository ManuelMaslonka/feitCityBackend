package sk.uniza.feit.site.mappers;

import org.mapstruct.*;
import sk.uniza.feit.site.domain.components.models.FeatureBoxComponent;
import sk.uniza.feit.site.rest.dto.FeatureBoxComponentDto;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface FeatureBoxComponentMapper {
    FeatureBoxComponent toEntity(FeatureBoxComponentDto featureBoxComponentDto);

    FeatureBoxComponentDto toDto(FeatureBoxComponent featureBoxComponent);

    List<FeatureBoxComponentDto> toDto(List<FeatureBoxComponent> featureBoxComponents);

    List<FeatureBoxComponent> toEntity(List<FeatureBoxComponentDto> featureBoxComponentDtos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FeatureBoxComponent partialUpdate(
            FeatureBoxComponentDto featureBoxComponentDto, @MappingTarget FeatureBoxComponent featureBoxComponent);
}
