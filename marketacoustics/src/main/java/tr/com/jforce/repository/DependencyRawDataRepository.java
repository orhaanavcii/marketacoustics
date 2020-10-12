package tr.com.jforce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.jforce.entity.DependencyRawData;

@Repository
public interface DependencyRawDataRepository extends JpaRepository<DependencyRawData, Long> {

}
