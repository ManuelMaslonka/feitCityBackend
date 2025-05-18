package sk.uniza.feit.site.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sk.uniza.feit.blog.domain.image.ImageService;
import sk.uniza.feit.site.domain.components.ComponentService;
import sk.uniza.feit.site.domain.components.models.CountdownComponent;
import sk.uniza.feit.site.domain.components.models.FeatureBoxComponent;
import sk.uniza.feit.site.domain.components.models.MenuComponent;
import sk.uniza.feit.site.domain.components.models.WhyFeitComponent;
import sk.uniza.feit.site.mappers.AfterSchoolComponentMapper;
import sk.uniza.feit.site.mappers.CountdownComponentMapper;
import sk.uniza.feit.site.mappers.FaqComponentMapper;
import sk.uniza.feit.site.mappers.FeatureBoxComponentMapper;
import sk.uniza.feit.site.mappers.FeitStoryComponentMapper;
import sk.uniza.feit.site.mappers.FooterMapper;
import sk.uniza.feit.site.mappers.LogoComponentMapper;
import sk.uniza.feit.site.mappers.MenuComponentMapper;
import sk.uniza.feit.site.mappers.OtherActivitiesComponentMapper;
import sk.uniza.feit.site.mappers.SliderComponentMapper;
import sk.uniza.feit.site.mappers.VideoComponentMapper;
import sk.uniza.feit.site.mappers.WhyFeitComponentMapper;
import sk.uniza.feit.site.rest.api.ComponentsRestApi;
import sk.uniza.feit.site.rest.dto.AfterSchoolComponentDto;
import sk.uniza.feit.site.rest.dto.CountdownComponentDto;
import sk.uniza.feit.site.rest.dto.CreateFeatureBoxRequestDto;
import sk.uniza.feit.site.rest.dto.DODComponentDto;
import sk.uniza.feit.site.rest.dto.FaqComponentDto;
import sk.uniza.feit.site.rest.dto.FeatureBoxComponentDto;
import sk.uniza.feit.site.rest.dto.FeitStoryComponentDto;
import sk.uniza.feit.site.rest.dto.FooterDto;
import sk.uniza.feit.site.rest.dto.GetFeatureBoxs200ResponseDto;
import sk.uniza.feit.site.rest.dto.LogoComponentDto;
import sk.uniza.feit.site.rest.dto.MenuComponentDto;
import sk.uniza.feit.site.rest.dto.OtherActivitiesComponentDto;
import sk.uniza.feit.site.rest.dto.SliderComponentDto;
import sk.uniza.feit.site.rest.dto.VideoComponentDto;
import sk.uniza.feit.site.rest.dto.WhyFeitComponentDto;
import sk.uniza.feit.site.utills.DateTimeConverter;

import java.util.List;

@RestController
public class ComponentController implements ComponentsRestApi {

    private final ComponentService componentService;

    private final VideoComponentMapper videoComponentMapper;
    private final CountdownComponentMapper countdownComponentMapper;
    private final WhyFeitComponentMapper whyFeitComponentMapper;
    private final DODComponentMapper dodComponentMapper;
    private final FeatureBoxComponentMapper featureBoxComponentMapper;
    private final SliderComponentMapper sliderComponentMapper;
    private final FeitStoryComponentMapper feitStoryComponentMapper;
    private final AfterSchoolComponentMapper afterSchoolComponentMapper;
    private final LogoComponentMapper logoComponentMapper;
    private final OtherActivitiesComponentMapper otherActivitiesComponentMapper;
    private final FaqComponentMapper faqComponentMapper;
    private final ImageService imageService;
    private final MenuComponentMapper menuComponentMapper;
    private final FooterMapper footerMapper;

    public ComponentController(ComponentService componentService, VideoComponentMapper videoComponentMapper, CountdownComponentMapper countdownComponentMapper,
                               WhyFeitComponentMapper whyFeitComponentMapper, DODComponentMapper dodComponentMapperConst,
                               FeatureBoxComponentMapper featureBoxComponentMapper,
                               SliderComponentMapper sliderComponentMapper, FeitStoryComponentMapper feitStoryComponentMapper,
                               AfterSchoolComponentMapper afterSchoolComponentMapper, LogoComponentMapper logoComponentMapper,
                               OtherActivitiesComponentMapper otherActivitiesComponentMapper, FaqComponentMapper faqComponentMapper,
                               ImageService imageService, MenuComponentMapper menuComponentMapper,
                               FooterMapper footerMapper) {
        this.componentService = componentService;
        this.videoComponentMapper = videoComponentMapper;
        this.countdownComponentMapper = countdownComponentMapper;
        this.whyFeitComponentMapper = whyFeitComponentMapper;
        this.dodComponentMapper = dodComponentMapperConst;
        this.featureBoxComponentMapper = featureBoxComponentMapper;
        this.sliderComponentMapper = sliderComponentMapper;
        this.feitStoryComponentMapper = feitStoryComponentMapper;
        this.afterSchoolComponentMapper = afterSchoolComponentMapper;
        this.logoComponentMapper = logoComponentMapper;
        this.otherActivitiesComponentMapper = otherActivitiesComponentMapper;
        this.faqComponentMapper = faqComponentMapper;
        this.imageService = imageService;
        this.menuComponentMapper = menuComponentMapper;
        this.footerMapper = footerMapper;
    }

    @Override
    public ResponseEntity<Void> createFeatureBox(CreateFeatureBoxRequestDto createFeatureBoxRequestDto) {
        List<FeatureBoxComponent> featureBoxComponents = featureBoxComponentMapper.toEntity(createFeatureBoxRequestDto.getItems());
        boolean visibility = createFeatureBoxRequestDto.getVisibility();
        componentService.createFeatureBox(featureBoxComponents, visibility);
        return null;
    }

    @Override
    public ResponseEntity<AfterSchoolComponentDto> getAfterSchoolComponent() {
        return ResponseEntity.ok(afterSchoolComponentMapper.toDto(componentService.getAfterSchoolComponent()));
    }

    @Override
    public ResponseEntity<CountdownComponentDto> getCountdownComponent() {
        CountdownComponent component = componentService.getComponent();
        CountdownComponentDto componentDto = new CountdownComponentDto();
        componentDto.setEndDate(DateTimeConverter.getString(component.getEndDate()));
        componentDto.setApplicationText(component.getApplicationText());
        componentDto.setVisible(component.isVisible());
        return ResponseEntity.ok(componentDto);
    }

    @Override
    public ResponseEntity<DODComponentDto> getDODComponent() {
        return ResponseEntity.ok(dodComponentMapper.toDto(componentService.getDODComponent()));
    }

    @Override
    public ResponseEntity<FaqComponentDto> getFaqComponent() {
        return ResponseEntity.ok(faqComponentMapper.toDto(componentService.getFaqComponent()));
    }

    @Override
    public ResponseEntity<GetFeatureBoxs200ResponseDto> getFeatureBoxs() {
        GetFeatureBoxs200ResponseDto responseDto = new GetFeatureBoxs200ResponseDto();
        List<FeatureBoxComponentDto> featureBoxComponentDtos = featureBoxComponentMapper.toDto(componentService.getFeatureBoxComponents());
        responseDto.setItems(featureBoxComponentDtos);
        responseDto.setVisibility(componentService.getFeatureBoxVisibility());
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<FeitStoryComponentDto> getFeitStoryComponent() {
        return ResponseEntity.ok(feitStoryComponentMapper.toDto(componentService.getFeitStoryComponent()));
    }

    @Override
    public ResponseEntity<FooterDto> getFooterComponent() {
        return ResponseEntity.ok(footerMapper.toDto(componentService.getFooterComponent()));
    }

    @Override
    public ResponseEntity<LogoComponentDto> getLogoComponent() {
        return ResponseEntity.ok(logoComponentMapper.toDto(componentService.getLogoComponent()));
    }

    @Override
    public ResponseEntity<MenuComponentDto> getMenuComponent() {
        MenuComponent menuComponent = componentService.getMenuComponent();
        if (menuComponent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(menuComponentMapper.toDto(menuComponent));
    }

    @Override
    public ResponseEntity<OtherActivitiesComponentDto> getOtherActivitiesComponent() {
        return ResponseEntity.ok(otherActivitiesComponentMapper.toDto(componentService.getOtherActivitiesComponent()));
    }

    @Override
    public ResponseEntity<SliderComponentDto> getSliderComponent() {
        return ResponseEntity.ok(sliderComponentMapper.toDto(componentService.getSliderComponent()));
    }

    @Override
    public ResponseEntity<VideoComponentDto> getVideoComponent() {
        return ResponseEntity.ok(videoComponentMapper.toDto(componentService.getVideoComponent()));
    }

    @Override
    public ResponseEntity<WhyFeitComponentDto> getWhyFeitComponent() {
        return ResponseEntity.ok(whyFeitComponentMapper.toDto(componentService.getWhyFeitComponent()));
    }

    @Override
    public ResponseEntity<Void> updateAfterSchoolComponent(AfterSchoolComponentDto afterSchoolComponentDto) {
        componentService.updateAfterSchoolComponent(afterSchoolComponentMapper.toEntity(afterSchoolComponentDto));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateCountdownComponent(CountdownComponentDto countdownComponentDto) {
        componentService.updateCountdown(countdownComponentMapper.mapToEntity(countdownComponentDto));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateDODComponent(DODComponentDto doDComponentDto) {
        componentService.updateDODComponent(dodComponentMapper.toEntity(doDComponentDto));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateFaqComponent(FaqComponentDto faqComponentDto) {
        componentService.updateFaqComponent(faqComponentMapper.toEntity(faqComponentDto));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateFeitStoryComponent(FeitStoryComponentDto feitStoryComponentDto) {
        componentService.updateFeitStoryComponent(feitStoryComponentMapper.toEntity(feitStoryComponentDto));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateFooterComponent(FooterDto footerDto) {
        componentService.updateFooterComponent(footerMapper.toEntity(footerDto));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateLogoComponent(LogoComponentDto logoComponentDto) {
        componentService.updateLogoComponent(logoComponentMapper.toEntity(logoComponentDto));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateMenuComponent(MenuComponentDto menuComponentDto) {
        MenuComponent entity = menuComponentMapper.toEntity(menuComponentDto);
        componentService.updateMenuComponent(entity);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateOtherActivitiesComponent(OtherActivitiesComponentDto otherActivitiesComponentDto) {
        componentService.updateOtherActivitiesComponent(otherActivitiesComponentMapper.toEntity(otherActivitiesComponentDto));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateSliderComponent(SliderComponentDto sliderComponentDto) {
        componentService.updateSliderComponent(sliderComponentMapper.toEntity(sliderComponentDto));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateVideoComponent(VideoComponentDto videoComponentDto) {
        componentService.updateVideoComponent(videoComponentMapper.toEntity(videoComponentDto));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateWhyFeitComponent(WhyFeitComponentDto whyFeitComponentDto) {
        WhyFeitComponent entity = whyFeitComponentMapper.toEntity(whyFeitComponentDto);
        componentService.updateWhyFeitComponent(entity);
        return ResponseEntity.ok().build();
    }

}
