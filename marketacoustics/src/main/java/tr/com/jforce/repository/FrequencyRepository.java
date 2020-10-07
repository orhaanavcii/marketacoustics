package tr.com.jforce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.jforce.entity.Frequency;

@Repository
public interface FrequencyRepository extends JpaRepository<Frequency, Long> {

	Frequency findFrequencyByActionId(Long id);
}
