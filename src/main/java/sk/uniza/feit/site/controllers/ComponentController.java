package sk.uniza.feit.site.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sk.uniza.feit.site.domain.components.ComponentService;
import sk.uniza.feit.site.domain.components.models.CountdownComponent;
import sk.uniza.feit.site.mappers.*;
import sk.uniza.feit.site.rest.api.ComponentsRestApi;
import sk.uniza.feit.site.rest.dto.*;
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

    public ComponentController(ComponentService componentService, VideoComponentMapper videoComponentMapper, CountdownComponentMapper countdownComponentMapper,
                               WhyFeitComponentMapper whyFeitComponentMapper, DODComponentMapper dodComponentMapperConst, FeatureBoxComponentMapper featureBoxComponentMapper,
                               SliderComponentMapper sliderComponentMapper, FeitStoryComponentMapper feitStoryComponentMapper,
                               AfterSchoolComponentMapper afterSchoolComponentMapper, LogoComponentMapper logoComponentMapper,
                               OtherActivitiesComponentMapper otherActivitiesComponentMapper, FaqComponentMapper faqComponentMapper) {
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
    }

    @Override
    public ResponseEntity<Void> createFeatureBox(FeatureBoxComponentDto featureBoxComponentDto) {
        componentService.createFeatureBox(featureBoxComponentMapper.toEntity(featureBoxComponentDto));
        return ResponseEntity.ok().build();
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
    public ResponseEntity<LogoComponentDto> getLogoComponent() {
        return ResponseEntity.ok(logoComponentMapper.toDto(componentService.getLogoComponent()));
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
        return null;
    }

    @Override
    public ResponseEntity<Void> updateCountdownComponent(CountdownComponentDto countdownComponentDto) {
        componentService.updateCountdown(countdownComponentMapper.toEntity(countdownComponentDto));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateDODComponent(DODComponentDto doDComponentDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateFaqComponent(FaqComponentDto faqComponentDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateFeitStoryComponent(FeitStoryComponentDto feitStoryComponentDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateLogoComponent(LogoComponentDto logoComponentDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateOtherActivitiesComponent(OtherActivitiesComponentDto otherActivitiesComponentDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateSliderComponent(SliderComponentDto sliderComponentDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateVideoComponent(VideoComponentDto videoComponentDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateWhyFeitComponent(WhyFeitComponentDto whyFeitComponentDto) {
        return null;
    }
}
