package sk.uniza.feit.site.domain.components;

import org.springframework.stereotype.Service;
import sk.uniza.feit.site.domain.components.models.*;
import sk.uniza.feit.site.domain.components.repository.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComponentService {

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
        return countDownRepository.findAll().getFirst();
    }

    public void updateCountdown(CountdownComponent component) {
        countDownRepository.save(component);
    }

    public VideoComponent getVideoComponent() {
        return videoRepository.findAll().getFirst();
    }

    public WhyFeitComponent getWhyFeitComponent() {
        return whyFeitRepository.findAll().getFirst();
    }

    public DODComponent getDODComponent() {
        return dodRepository.findAll().getFirst();
    }

    public List<FeatureBoxComponent> getFeatureBoxComponents() {
        return featureBoxRepository.findAll().stream().sorted(
                (f1, f2) -> f1.getId().compareTo(f2.getId())
        ).toList();
    }

    public boolean getFeatureBoxVisibility() {
        return getFeatureBoxComponents().stream().anyMatch(FeatureBoxComponent::isVisible);

    }

    public SliderComponent getSliderComponent() {
        return sliderRepository.findAll().getFirst();
    }

    public FeitStoryComponent getFeitStoryComponent() {
        return feitStoryRepository.findAll().getFirst();
    }

    public AfterSchoolComponent getAfterSchoolComponent() {
            return afterSchoolRepository.findAll().getFirst();
        }

    public LogoComponent getLogoComponent() {
        return logoRepository.findAll().getFirst();
    }

    public OtherActivitiesComponent getOtherActivitiesComponent() {
        return otherActivitiesRepository.findAll().getFirst();
    }

    public FaqComponent getFaqComponent() {
        return faqRepository.findAll().getFirst();
    }
}
