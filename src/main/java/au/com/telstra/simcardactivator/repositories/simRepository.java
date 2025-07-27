package au.com.telstra.simcardactivator.repositories;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import au.com.telstra.simcardactivator.entities.simEntity;

@Repository
public interface simRepository extends JpaRepository<simEntity, String> {
    // custom query methods (if needed)
}