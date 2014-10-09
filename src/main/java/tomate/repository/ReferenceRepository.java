
package tomate.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import tomate.domain.Reference;

/**
 *
 * @author Toni Oksanen
 */
public interface ReferenceRepository extends JpaRepository<Reference, Long> {
  public List<Reference> findByType( Integer type );
}
