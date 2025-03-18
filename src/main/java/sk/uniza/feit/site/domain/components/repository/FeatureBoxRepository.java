package sk.uniza.feit.site.domain.components.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.uniza.feit.site.domain.components.models.FeatureBoxComponent;

public interface FeatureBoxRepository extends JpaRepository<FeatureBoxComponent, Long> {
}
