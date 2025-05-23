package sk.uniza.feit.site.domain.components;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.uniza.feit.site.domain.components.models.LogoItem;

public interface LogoItemRepository extends JpaRepository<LogoItem, Long> {
}
