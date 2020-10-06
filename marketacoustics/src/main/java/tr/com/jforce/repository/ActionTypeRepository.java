package tr.com.jforce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.jforce.entity.ActionType;

@Repository
public interface ActionTypeRepository extends JpaRepository<ActionType, Long> {

}
