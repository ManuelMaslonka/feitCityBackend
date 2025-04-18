package sk.uniza.feit.site.domain.components.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.uniza.feit.site.domain.components.models.MenuComponent;

@Repository
public interface MenuRepository extends JpaRepository<MenuComponent, Long> {
}
