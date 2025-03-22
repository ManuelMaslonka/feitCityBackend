package sk.uniza.feit.blog.domain;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Post")
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "title")
    private String title;

    @Column(nullable = false, name = "content")
    private String content;

    @Column(name = "author")
    private String author;

    // Timestamp
    @Timestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @OneToMany(targetEntity = Tag.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "tags")
    private List<Tag> tags;

    @Column(name = "main_image")
    private byte[] mainImage;

    public Post() {
    }

    public Post(Long id, String title, String content, String author, LocalDateTime createdAt, List<Tag> tags, byte[] mainImage) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.tags = tags;
        this.mainImage = mainImage;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public byte[] getMainImage() {
        return mainImage;
    }

    public void setMainImage(byte[] mainImage) {
        this.mainImage = mainImage;
    }
}
