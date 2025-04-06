package sk.uniza.feit.site.domain.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sk.uniza.feit.site.domain.components.models.*;
import sk.uniza.feit.site.domain.components.repository.*;

import java.util.List;

@Service
public class ComponentService {

    @Value("${application.image.base-url}")
    private String imageBaseUrl;

    @Value("${application.url.base-url}")
    private String baseUrl;

    @Value("${application.url.api-url}")
    private String apiUrl;

    private final CountDownRepository countDownRepository;
    private final VideoRepository videoRepository;
    private final WhyFeitRepository whyFeitRepository;
    private final DODRepository dodRepository;
    private final FeatureBoxRepository featureBoxRepository;
    private final SliderRepository sliderRepository;
    private final FeitStoryRepository feitStoryRepository;
    private final AfterSchoolRepository afterSchoolRepository;
    private final LogoRepository logoRepository;
    private final OtherActivitiesRepository otherActivitiesRepository;
    private final FaqRepository faqRepository;

    public ComponentService(CountDownRepository countDownRepository, VideoRepository videoRepository, WhyFeitRepository whyFeitRepository,
                            DODRepository dodRepository, FeatureBoxRepository featureBoxRepository, SliderRepository sliderRepository,
                            FeitStoryRepository feitStoryRepository, AfterSchoolRepository afterSchoolRepository, LogoRepository logoRepository,
                            OtherActivitiesRepository otherActivitiesRepository, FaqRepository faqRepository) {
        this.countDownRepository = countDownRepository;
        this.videoRepository = videoRepository;
        this.whyFeitRepository = whyFeitRepository;
        this.dodRepository = dodRepository;
        this.featureBoxRepository = featureBoxRepository;
        this.sliderRepository = sliderRepository;
        this.feitStoryRepository = feitStoryRepository;
        this.afterSchoolRepository = afterSchoolRepository;
        this.logoRepository = logoRepository;
        this.otherActivitiesRepository = otherActivitiesRepository;
        this.faqRepository = faqRepository;
    }

    public CountdownComponent getComponent() {
        return countDownRepository.findById(1L).orElse(null);
    }

    public void updateCountdown(CountdownComponent component) {
        CountdownComponent existingComponent = countDownRepository.findById(1L).orElse(null);
        if (existingComponent != null) {
            existingComponent.setEndDate(component.getEndDate());
            existingComponent.setApplicationText(component.getApplicationText());
            existingComponent.setVisible(component.isVisible());
            countDownRepository.save(existingComponent);
        } else {
            component.setId(1L);
            countDownRepository.save(component);
        }
    }

    public void updateVideoComponent(VideoComponent component) {
        VideoComponent existingComponent = videoRepository.findById(1L).orElse(null);
        if (existingComponent != null) {
            existingComponent.setTitle(component.getTitle());
            existingComponent.setDescription(component.getDescription());
            existingComponent.setVideoUrl(component.getVideoUrl());
            existingComponent.setVisible(component.isVisible());
            videoRepository.save(existingComponent);
        } else {
            component.setId(1L);
            videoRepository.save(component);
        }
    }

    public void updateWhyFeitComponent(WhyFeitComponent component) {
        WhyFeitComponent existingComponent = whyFeitRepository.findById(1L).orElse(null);
        if (existingComponent != null) {
            existingComponent.setTitle(component.getTitle());
            existingComponent.setWhyFeitLists(component.getWhyFeitLists());
            existingComponent.setImageUrl(component.getImageUrl());
            existingComponent.setVideoUrl(component.getVideoUrl());
            existingComponent.setCountPrograms(component.getCountPrograms());
            existingComponent.setCountDescription(component.getCountDescription());
            existingComponent.setAnnualStipend(component.getAnnualStipend());
            existingComponent.setSalary(component.getSalary());
            existingComponent.setApplication(component.getApplication());
            existingComponent.setVisible(component.isVisible());
            whyFeitRepository.save(existingComponent);
        } else {
            component.setId(1L);
            whyFeitRepository.save(component);
        }
    }

    public void updateDODComponent(DODComponent component) {
        DODComponent existingComponent = dodRepository.findById(1L).orElse(null);
        if (existingComponent != null) {
            existingComponent.setTitle(component.getTitle());
            existingComponent.setButtonText(component.getButtonText());
            existingComponent.setButtonLink(component.getButtonLink());
            existingComponent.setVisible(component.isVisible());
            dodRepository.save(existingComponent);
        } else {
            component.setId(1L);
            dodRepository.save(component);
        }
    }

    public void updateSliderComponent(SliderComponent component) {
        SliderComponent existingComponent = sliderRepository.findById(1L).orElse(null);
        if (existingComponent != null) {
            existingComponent.setTitle(component.getTitle());
            existingComponent.setLabel(component.getLabel());
            existingComponent.setDescription(component.getDescription());
            existingComponent.setItems(component.getItems());
            existingComponent.setVisible(component.isVisible());
            sliderRepository.save(existingComponent);
        } else {
            component.setId(1L);
            sliderRepository.save(component);
        }
    }

    public void updateFeitStoryComponent(FeitStoryComponent component) {
        FeitStoryComponent existingComponent = feitStoryRepository.findById(1L).orElse(null);
        if (existingComponent != null) {
            existingComponent.setTitle(component.getTitle());
            existingComponent.setVideoItemList(component.getVideoItemList());
            existingComponent.setVisible(component.isVisible());
            feitStoryRepository.save(existingComponent);
        } else {
            component.setId(1L);
            feitStoryRepository.save(component);
        }
    }

    public void updateAfterSchoolComponent(AfterSchoolComponent component) {
        AfterSchoolComponent existingComponent = afterSchoolRepository.findById(1L).orElse(null);
        if (existingComponent != null) {
            existingComponent.setTitle(component.getTitle());
            existingComponent.setLabel(component.getLabel());
            existingComponent.setDescription(component.getDescription());
            existingComponent.setImageUrl(component.getImageUrl());
            existingComponent.setImageUrl1(component.getImageUrl1());
            existingComponent.setVisible(component.getVisible());
            afterSchoolRepository.save(existingComponent);
        } else {
            component.setId(1L);
            afterSchoolRepository.save(component);
        }
    }

    public void updateLogoComponent(LogoComponent component) {
        LogoComponent existingComponent = logoRepository.findById(1L).orElse(null);
        if (existingComponent != null) {
            existingComponent.setLogoItems(component.getLogoItems());
            existingComponent.setVisible(component.isVisible());
            logoRepository.save(existingComponent);
        } else {
            component.setId(1L);
            logoRepository.save(component);
        }
    }

    public void updateOtherActivitiesComponent(OtherActivitiesComponent component) {
        OtherActivitiesComponent existingComponent = otherActivitiesRepository.findById(1L).orElse(null);
        if (existingComponent != null) {
            existingComponent.setTitle(component.getTitle());
            existingComponent.setLabel(component.getLabel());
            existingComponent.setBannerItems(component.getBannerItems());
            existingComponent.setVisible(component.isVisible());
            otherActivitiesRepository.save(existingComponent);
        } else {
            component.setId(1L);
            otherActivitiesRepository.save(component);
        }
    }

    public void updateFaqComponent(FaqComponent component) {
        FaqComponent existingComponent = faqRepository.findById(1L).orElse(null);
        if (existingComponent != null) {
            existingComponent.setVisible(component.isVisible());
            faqRepository.save(existingComponent);
        } else {
            component.setId(1L);
            faqRepository.save(component);
        }
    }

    public VideoComponent getVideoComponent() {
        return videoRepository.findById(1L).orElse(null);
    }

    public WhyFeitComponent getWhyFeitComponent() {
        WhyFeitComponent whyFeitComponent = whyFeitRepository.findById(1L).orElse(null);
        whyFeitComponent.setImageUrl(createUrlFromImagePath(whyFeitComponent.getImageUrl()));
        return whyFeitComponent;
    }

    private String createUrlFromImagePath(String imageUrl) {
        return baseUrl + apiUrl + this.imageBaseUrl + imageUrl;
    }

    public DODComponent getDODComponent() {
        return dodRepository.findById(1L).orElse(null);
    }

    public List<FeatureBoxComponent> getFeatureBoxComponents() {
        List<FeatureBoxComponent> list = featureBoxRepository.findAll().stream().sorted(
                (f1, f2) -> f1.getId().compareTo(f2.getId())
        ).toList();

        for (FeatureBoxComponent component : list) {
            component.setImageUrl(createUrlFromImagePath(component.getImageUrl()));
        }

        return list;
    }

    public boolean getFeatureBoxVisibility() {
        return getFeatureBoxComponents().stream().anyMatch(FeatureBoxComponent::isVisible);

    }

    public SliderComponent getSliderComponent() {
        SliderComponent sliderComponent = sliderRepository.findById(1L).orElse(null);

        sliderComponent.getItems().forEach(
                sliderItem -> sliderItem.setImageUrl(createUrlFromImagePath(sliderItem.getImageUrl()))
        );

        return sliderComponent;
    }

    public FeitStoryComponent getFeitStoryComponent() {
        FeitStoryComponent feitStoryComponent = feitStoryRepository.findById(1L).orElse(null);
        feitStoryComponent.getVideoItemList().forEach(
                videoItem -> videoItem.setImageUrl(createUrlFromImagePath(videoItem.getImageUrl()))
        );
        return feitStoryComponent;
    }

    public AfterSchoolComponent getAfterSchoolComponent() {
        AfterSchoolComponent afterSchoolComponent = afterSchoolRepository.findById(1L).orElse(null);
        afterSchoolComponent.setImageUrl(createUrlFromImagePath(afterSchoolComponent.getImageUrl()));
        afterSchoolComponent.setImageUrl1(createUrlFromImagePath(afterSchoolComponent.getImageUrl1()));
        return afterSchoolComponent;
    }

    public LogoComponent getLogoComponent() {
        LogoComponent logoComponent = logoRepository.findById(1L).orElse(null);
        logoComponent.getLogoItems()
                .forEach(logoItem -> logoItem.setImageUrl(createUrlFromImagePath(logoItem.getImageUrl())));
        return logoComponent;
    }

    public OtherActivitiesComponent getOtherActivitiesComponent() {
        return otherActivitiesRepository.findById(1L).orElse(null);
    }

    public FaqComponent getFaqComponent() {
        return faqRepository.findById(1L).orElse(null);
    }

    public void createFeatureBox(FeatureBoxComponent entity) {
        FeatureBoxComponent component = featureBoxRepository.findById(1L).orElse(null);

        if (component != null) {
            component.setVisible(entity.isVisible());
            component.setTitle(entity.getTitle());
            component.setDescription(entity.getDescription());
            component.setImageUrl(entity.getImageUrl());
            component.setLink(entity.getLink());
            featureBoxRepository.save(component);
        } else {
            // create new component
            entity.setId(1L);
            featureBoxRepository.save(entity);
        }
    }
}
