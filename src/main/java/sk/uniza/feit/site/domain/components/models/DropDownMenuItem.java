package sk.uniza.feit.site.domain.components.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "dropdown_menu_item")
public class DropDownMenuItem {

    @Id
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "url")
    private String url;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dropdown_menu_item_id")
    private List<DropDownMenuItems> dropdownMenuItems;

    public DropDownMenuItem() {}

    public DropDownMenuItem(Long id, String text, String url, List<DropDownMenuItems> dropdownMenuItems) {
        this.id = id;
        this.text = text;
        this.url = url;
        this.dropdownMenuItems = dropdownMenuItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<DropDownMenuItems> getDropdownMenuItems() {
        return dropdownMenuItems;
    }

    public void setDropdownMenuItems(List<DropDownMenuItems> dropdownMenuItems) {
        this.dropdownMenuItems = dropdownMenuItems;
    }
}
