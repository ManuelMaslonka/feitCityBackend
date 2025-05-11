package sk.uniza.feit.site.domain.components.models;


import jakarta.persistence.*;

import java.util.List;

@Table(name = "why_feit_component")
@Entity
public class WhyFeitComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "visible")
    private boolean visible;

    @Column(name = "title", length = 1024) // Increased length
    private String title;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "why_feit_component_id")
    private List<WhyFeitList> whyFeitLists;

    @Column(name = "image_url", length = 2048) // Increased length for URLs
    private String imageUrl;

    @Column(name = "video_url", length = 2048) // Increased length for URLs
    private String videoUrl;

    @Column(name = "countPrograms") // Removed length = 1000 as it's an int
    private int countPrograms;

    @Column(name = "countDescription", columnDefinition = "TEXT") // Changed to TEXT for potentially long descriptions
    private String countDescription;

    @Column(name = "annualStipend")
    private int annualStipend;

    @Column(name = "salary")
    private int salary;

    @Column(name = "application", columnDefinition = "TEXT") // Changed to TEXT or increased length
    private String application;

    public WhyFeitComponent() {
    }

    public WhyFeitComponent(Long id, boolean visible, String title, List<WhyFeitList> whyFeitLists, String imageUrl, String videoUrl, int countPrograms,
                            String countDescription, int annualStipend, int salary, String application) {
        this.id = id;
        this.visible = visible;
        this.title = title;
        this.whyFeitLists = whyFeitLists;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
        this.countPrograms = countPrograms;
        this.countDescription = countDescription;
        this.annualStipend = annualStipend;
        this.salary = salary;
        this.application = application;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<WhyFeitList> getWhyFeitLists() {
        return whyFeitLists;
    }

    public void setWhyFeitLists(List<WhyFeitList> whyFeitLists) {
        this.whyFeitLists = whyFeitLists;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getCountPrograms() {
        return countPrograms;
    }

    public void setCountPrograms(int countPrograms) {
        this.countPrograms = countPrograms;
    }

    public String getCountDescription() {
        return countDescription;
    }

    public void setCountDescription(String countDescription) {
        this.countDescription = countDescription;
    }

    public int getAnnualStipend() {
        return annualStipend;
    }

    public void setAnnualStipend(int annualStipend) {
        this.annualStipend = annualStipend;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }
}
