package sk.uniza.feit.site.domain.components.models;

import jakarta.persistence.*;

import java.util.List;

@Table
@Entity
public class MenuComponent {

    @Id
    @SequenceGenerator(
            name = "menu_component_sequence",
            sequenceName = "menu_component_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "menu_component_sequence"
    )
    private Long id;

    @Column(name = "visible")
    private boolean visible;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_component_id")
    private List<MenuItem> menuItems;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_component_id")
    private List<DropDownMenuItem> dropdownMenuItems;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_component_id")
    private Button button;

    public MenuComponent() {}

    public MenuComponent(Long id, boolean visible, List<MenuItem> menuItems, List<DropDownMenuItem> dropdownMenuItems, Button button) {
        this.id = id;
        this.visible = visible;
        this.menuItems = menuItems;
        this.dropdownMenuItems = dropdownMenuItems;
        this.button = button;
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

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public List<DropDownMenuItem> getDropdownMenuItems() {
        return dropdownMenuItems;
    }

    public void setDropdownMenuItems(List<DropDownMenuItem> dropdownMenuItems) {
        this.dropdownMenuItems = dropdownMenuItems;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
