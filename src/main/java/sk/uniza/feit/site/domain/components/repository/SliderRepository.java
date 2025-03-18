package sk.uniza.feit.site.domain.components.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.uniza.feit.site.domain.components.models.SliderComponent;

public interface SliderRepository extends JpaRepository<SliderComponent, Long> {
}
