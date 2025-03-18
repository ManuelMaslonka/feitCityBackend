package sk.uniza.feit.site.domain.components.models;

    import jakarta.persistence.Column;
    import jakarta.persistence.Entity;
    import jakarta.persistence.Id;
    import jakarta.persistence.Table;

    @Table(name = "video_component")
    @Entity(name = "VideoComponent")
    public class VideoComponent {

        @Id
        private Long id;

        @Column(name = "visible")
        private boolean visible;

        @Column(name = "video_url")
        private String videoUrl;

        @Column(name = "title")
        private String title;

        @Column(name = "description")
        private String description;

        // Default constructor
        public VideoComponent() {
        }

        // Parameterized constructor
        public VideoComponent(Long id, boolean visible, String videoUrl, String title, String description) {
            this.id = id;
            this.visible = visible;
            this.videoUrl = videoUrl;
            this.title = title;
            this.description = description;
        }

        // Getters and setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public boolean isVisible() {
            return visible;
        }

        public void setVisible(boolean visible) {
            this.visible = visible;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
