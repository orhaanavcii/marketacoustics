package tr.com.jforce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.jforce.entity.DataSource;

@Repository
public interface DataSourceRepository extends JpaRepository<DataSource, Long> {

}
