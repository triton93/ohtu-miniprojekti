
package tomate.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author Toni Oksanen
 */

@Entity
public abstract class Reference extends AbstractPersistable<Long> {
  
}
