package tr.com.jforce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.jforce.entity.ActionContentLink;

@Repository
public interface ActionContentLinkRepository extends JpaRepository<ActionContentLink, Long>{

}
