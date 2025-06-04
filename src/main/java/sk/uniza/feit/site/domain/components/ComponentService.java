package sk.uniza.feit.site.domain.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sk.uniza.feit.site.domain.components.models.AfterSchoolComponent;
import sk.uniza.feit.site.domain.components.models.ContactColumn;
import sk.uniza.feit.site.domain.components.models.CountdownComponent;
import sk.uniza.feit.site.domain.components.models.DODComponent;
import sk.uniza.feit.site.domain.components.models.FaqComponent;
import sk.uniza.feit.site.domain.components.models.FeatureBoxComponent;
import sk.uniza.feit.site.domain.components.models.FeitStoryComponent;
import sk.uniza.feit.site.domain.components.models.Footer;
import sk.uniza.feit.site.domain.components.models.LocationColumn;
import sk.uniza.feit.site.domain.components.models.LogoComponent;
import sk.uniza.feit.site.domain.components.models.LogoItem;
import sk.uniza.feit.site.domain.components.models.MenuComponent;
import sk.uniza.feit.site.domain.components.models.NavigationColumn;
import sk.uniza.feit.site.domain.components.models.OtherActivitiesComponent;
import sk.uniza.feit.site.domain.components.models.ShopColumn;
import sk.uniza.feit.site.domain.components.models.SliderComponent;
import sk.uniza.feit.site.domain.components.models.SliderItem;
import sk.uniza.feit.site.domain.components.models.SocialColumn;
import sk.uniza.feit.site.domain.components.models.VideoComponent;
import sk.uniza.feit.site.domain.components.models.VideoItem;
import sk.uniza.feit.site.domain.components.models.WhyFeitComponent;
import sk.uniza.feit.site.domain.components.repository.AfterSchoolRepository;
import sk.uniza.feit.site.domain.components.repository.CountDownRepository;
import sk.uniza.feit.site.domain.components.repository.DODRepository;
import sk.uniza.feit.site.domain.components.repository.FaqRepository;
import sk.uniza.feit.site.domain.components.repository.FeatureBoxRepository;
import sk.uniza.feit.site.domain.components.repository.FeitStoryRepository;
import sk.uniza.feit.site.domain.components.repository.FooterRepository;
import sk.uniza.feit.site.domain.components.repository.LogoRepository;
import sk.uniza.feit.site.domain.components.repository.MenuRepository;
import sk.uniza.feit.site.domain.components.repository.OtherActivitiesRepository;
import sk.uniza.feit.site.domain.components.repository.SliderRepository;
import sk.uniza.feit.site.domain.components.repository.VideoRepository;
import sk.uniza.feit.site.domain.components.repository.WhyFeitRepository;

import java.util.List;
import java.util.stream.Collectors;

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
    private final MenuRepository menuRepository;
    private final FooterRepository footerRepository;
    private final LogoItemRepository logoItemRepository;

    public ComponentService(CountDownRepository countDownRepository, VideoRepository videoRepository, WhyFeitRepository whyFeitRepository,
                            DODRepository dodRepository, FeatureBoxRepository featureBoxRepository, SliderRepository sliderRepository,
                            FeitStoryRepository feitStoryRepository, AfterSchoolRepository afterSchoolRepository, LogoRepository logoRepository,
                            OtherActivitiesRepository otherActivitiesRepository, FaqRepository faqRepository, MenuRepository menuRepository,
                            FooterRepository footerRepository, LogoItemRepository logoItemRepository) {
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
        this.menuRepository = menuRepository;
        this.footerRepository = footerRepository;
        this.logoItemRepository = logoItemRepository;
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
            existingComponent.setImageUrl(urlTrimmer(component.getImageUrl()));
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

            List<SliderItem> trimmedSliderItems = component.getItems().stream()
                    .map(sliderItem -> {
                        String imageUrl = sliderItem.getImageUrl();
                        if (imageUrl != null && imageUrl.contains(baseUrl + apiUrl + imageBaseUrl)) {
                            String updatedImageUrl = imageUrl.replace(baseUrl + apiUrl + imageBaseUrl, "");
                            return new SliderItem(sliderItem.getId(), sliderItem.getTitle(), sliderItem.getDescription(), sliderItem.getInfoDescription(), sliderItem.getLabel()
                                    , updatedImageUrl, sliderItem.getVideoUrl(), sliderItem.getIconsStyle());
                        }
                        return sliderItem;
                    }).collect(Collectors.toList());

            existingComponent.setItems(trimmedSliderItems);
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

            List<VideoItem> trimmedVideoItems = component.getVideoItemList().stream()
                    .map(videoItem -> {
                        String imageUrl = videoItem.getImageUrl();
                        if (imageUrl != null && imageUrl.contains(baseUrl + apiUrl + imageBaseUrl)) {
                            String updatedImageUrl = imageUrl.replace(baseUrl + apiUrl + imageBaseUrl, "");
                            return new VideoItem(videoItem.getId(), videoItem.getTitle(), videoItem.getVideoUrl(), updatedImageUrl);
                        }
                        return videoItem;
                    }).collect(Collectors.toList());

            existingComponent.setVideoItemList(trimmedVideoItems);
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
            existingComponent.setImageUrl(urlTrimmer(component.getImageUrl()));
            existingComponent.setImageUrl1(urlTrimmer(component.getImageUrl1()));
            existingComponent.setVisible(component.getVisible());
            afterSchoolRepository.save(existingComponent);
        } else {
            component.setId(1L);
            afterSchoolRepository.save(component);
        }
    }

    public void updateLogoComponent(LogoComponent component) {
        LogoComponent existingComponent = logoRepository.findById(1L).orElse(null);
        if (existingComponent == null) {
            component.setId(1L);
            logoRepository.save(component);
            return;
        }

        existingComponent.getLogoItems().clear();

        for (LogoItem logoItem : component.getLogoItems()) {
            String imageUrl = logoItem.getImageUrl();
            if (imageUrl != null && imageUrl.contains(baseUrl + apiUrl + imageBaseUrl)) {
                String updatedImageUrl = imageUrl.replace(baseUrl + apiUrl + imageBaseUrl, "");
                LogoItem newLogoItem = new LogoItem(null, updatedImageUrl, logoItem.isAlt());
                existingComponent.addLogoItem(newLogoItem);
            } else if (imageUrl != null) {
                LogoItem newLogoItem = new LogoItem(null, imageUrl, logoItem.isAlt());
                existingComponent.addLogoItem(newLogoItem);
            }
        }

        existingComponent.setVisible(component.isVisible());
        logoRepository.save(existingComponent);
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

    public MenuComponent getMenuComponent() {
        return menuRepository.findById(1L).orElse(null);
    }

    public void updateMenuComponent(MenuComponent component) {
        MenuComponent existingComponent = menuRepository.findById(1L).orElse(null);
        if (existingComponent != null) {
            existingComponent.setVisible(component.isVisible());
            existingComponent.setMenuItems(component.getMenuItems());
            existingComponent.setDropdownMenuItems(component.getDropdownMenuItems());
            menuRepository.save(existingComponent);
        } else {
            component.setId(1L);
            menuRepository.save(component);
        }
    }

    public void createFeatureBox(List<FeatureBoxComponent> entity, boolean visible) {
        List<FeatureBoxComponent> existingComponents = featureBoxRepository.findAll();
        if (existingComponents != null && !existingComponents.isEmpty()) {
            for (int i = 0; i < existingComponents.size(); i++) {
                FeatureBoxComponent component = existingComponents.get(i);
                if (i < entity.size()) {
                    component.setVisible(visible);
                    component.setTitle(entity.get(i).getTitle());
                    component.setDescription(entity.get(i).getDescription());
                    String imageUrl = entity.get(i).getImageUrl().replace(baseUrl + apiUrl + imageBaseUrl, "");
                    component.setImageUrl(imageUrl);
                    component.setLink(entity.get(i).getLink());
                    featureBoxRepository.save(component);
                }
            }
        } else {
            for (FeatureBoxComponent component : entity) {
                component.setVisible(visible);
                featureBoxRepository.save(component);
            }
        }
    }

    public void updateFooterComponent(Footer entity) {
        Footer existingComponent = footerRepository.findById(1L).orElse(null);
        if (existingComponent != null) {
            // Clear existing collections
            existingComponent.getLocationColumn().clear();
            existingComponent.getContactColumn().clear();
            existingComponent.getSocialColumn().clear();
            existingComponent.getShopColumn().clear();
            existingComponent.getNavigationColumn().clear();

            // Save the cleared collections first
            footerRepository.save(existingComponent);

            // Create new instances for each column instead of modifying existing ones
            if (entity.getLocationColumn() != null) {
                entity.getLocationColumn().forEach(item -> {
                    existingComponent.getLocationColumn().add(new LocationColumn(null, item.getText(), item.getUrl()));
                });
            }

            if (entity.getContactColumn() != null) {
                entity.getContactColumn().forEach(item -> {
                    existingComponent.getContactColumn().add(new ContactColumn(null, item.getText(), item.getUrl()));
                });
            }

            if (entity.getSocialColumn() != null) {
                entity.getSocialColumn().forEach(item -> {
                    existingComponent.getSocialColumn().add(new SocialColumn(null, item.getText(), item.getUrl(), item.getIcon()));
                });
            }

            if (entity.getShopColumn() != null) {
                entity.getShopColumn().forEach(item -> {
                    existingComponent.getShopColumn().add(new ShopColumn(null, item.getText(), item.getUrl()));
                });
            }

            if (entity.getNavigationColumn() != null) {
                entity.getNavigationColumn().forEach(item -> {
                    existingComponent.getNavigationColumn().add(new NavigationColumn(null, item.getText(), item.getUrl()));
                });
            }

            footerRepository.save(existingComponent);
        } else {
            entity.setId(1L);
            footerRepository.save(entity);
        }
    }
    public Footer getFooterComponent() {

        return footerRepository.findById(1L).orElse(null);

    }

    public void createLogoComponent(String imageUrl) {
        LogoComponent all = logoRepository.findAll().getFirst();
        LogoItem newItem = new LogoItem(imageUrl);
        logoItemRepository.save(newItem);
        all.addLogoItem(newItem);
        logoRepository.save(all);
    }

    private String urlTrimmer(String imageUrl) {
        if (imageUrl != null && imageUrl.contains(baseUrl + apiUrl + imageBaseUrl)) {
            return imageUrl.replace(baseUrl + apiUrl + imageBaseUrl, "");
        }
        return imageUrl;
    }
}
