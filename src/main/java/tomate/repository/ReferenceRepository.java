
package tomate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tomate.domain.Reference;

/**
 *
 * @author Toni Oksanen
 */
public interface ReferenceRepository extends JpaRepository<Reference, Long> {
  
}
