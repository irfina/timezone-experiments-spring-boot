/*
 * PersonRepository.java
 *
 * Created on Nov 01, 2022, 22.31
 */
package demo.irfin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Irfin A.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, UUID>
{
}
