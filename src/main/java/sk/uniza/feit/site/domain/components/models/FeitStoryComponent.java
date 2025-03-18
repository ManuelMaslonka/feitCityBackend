package sk.uniza.feit.site.domain.components.models;

import jakarta.persistence.*;

import java.util.List;

@Table
@Entity
public class FeitStoryComponent {

    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "visible")
    private boolean visible;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "feit_story_component_id")
    private List<VideoItem> videoItemList;

    public FeitStoryComponent(Long id, String title, boolean visible, List<VideoItem> videoItemList) {
        this.id = id;
        this.title = title;
        this.visible = visible;
        this.videoItemList = videoItemList;
    }

    public FeitStoryComponent() {

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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public List<VideoItem> getVideoItemList() {
        return videoItemList;
    }

    public void setVideoItemList(List<VideoItem> videoItemList) {
        this.videoItemList = videoItemList;
    }
}
