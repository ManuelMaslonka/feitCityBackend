package sk.uniza.feit.site.domain.components.models;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "other_activities")
@Entity(name = "OtherActivitiesComponent")
public class OtherActivitiesComponent {


    @Id
    @SequenceGenerator(
            name = "other_activities_id_seq",
            sequenceName = "other_activities_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(generator = "other_activities_id_seq")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "label")
    private String label;

    @Column(name = "visible")
    private boolean visible;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "other_activities_id")
    private List<BannerItems> bannerItems;

    public OtherActivitiesComponent() {}

    public OtherActivitiesComponent(Long id, String title, String label, boolean visible, List<BannerItems> bannerItems) {
        this.id = id;
        this.title = title;
        this.label = label;
        this.visible = visible;
        this.bannerItems = bannerItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public List<BannerItems> getBannerItems() {
        return bannerItems;
    }

    public void setBannerItems(List<BannerItems> bannerItems) {
        this.bannerItems = bannerItems;
    }
}
