package sk.uniza.feit.site.domain.components.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Table
@Entity
public class Footer {

    @Id
    private Long id;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "footer_id")
    private List<LocationColumn> locationColumn;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "footer_id")
    private List<ContactColumn> contactColumn;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "footer_id")
    private List<SocialColumn> socialColumn;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "footer_id")
    private List<ShopColumn> shopColumn;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "footer_id")
    private List<NavigationColumn> navigationColumn;


    public Footer() {
    }

    public Footer(Long id, List<LocationColumn> locationColumn, List<ContactColumn> contactColumn, List<SocialColumn> socialColumn, List<ShopColumn> shopColumn,
                  List<NavigationColumn> navigationColumn) {
        this.id = id;
        this.locationColumn = locationColumn;
        this.contactColumn = contactColumn;
        this.socialColumn = socialColumn;
        this.shopColumn = shopColumn;
        this.navigationColumn = navigationColumn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<LocationColumn> getLocationColumn() {
        return locationColumn;
    }

    public void setLocationColumn(List<LocationColumn> locationColumn) {
        this.locationColumn = locationColumn;
    }

    public List<ContactColumn> getContactColumn() {
        return contactColumn;
    }

    public void setContactColumn(List<ContactColumn> contactColumn) {
        this.contactColumn = contactColumn;
    }

    public List<SocialColumn> getSocialColumn() {
        return socialColumn;
    }

    public void setSocialColumn(List<SocialColumn> socialColumn) {
        this.socialColumn = socialColumn;
    }

    public List<ShopColumn> getShopColumn() {
        return shopColumn;
    }

    public void setShopColumn(List<ShopColumn> shopColumn) {
        this.shopColumn = shopColumn;
    }

    public List<NavigationColumn> getNavigationColumn() {
        return navigationColumn;
    }

    public void setNavigationColumn(List<NavigationColumn> navigationColumn) {
        this.navigationColumn = navigationColumn;
    }
}
