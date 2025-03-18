package sk.uniza.feit.site.mappers;

import org.mapstruct.*;
import sk.uniza.feit.site.domain.components.models.OtherActivitiesComponent;
import sk.uniza.feit.site.rest.dto.OtherActivitiesComponentDto;

@Mapper(uses = {BannerItemsMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OtherActivitiesComponentMapper {
    OtherActivitiesComponent toEntity(OtherActivitiesComponentDto otherActivitiesComponentDto);

    OtherActivitiesComponentDto toDto(OtherActivitiesComponent otherActivitiesComponent);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OtherActivitiesComponent partialUpdate(
            OtherActivitiesComponentDto otherActivitiesComponentDto, @MappingTarget OtherActivitiesComponent otherActivitiesComponent);
}
