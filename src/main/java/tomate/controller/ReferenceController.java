
package tomate.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tomate.domain.BookReference;
import tomate.repository.ReferenceRepository;

/**
 *
 * @author Toni Oksanen
 */

@RestController
@RequestMapping( "/api/references" )
public class ReferenceController {
  
  @Autowired
  private ReferenceRepository referenceRepository;
  
  @RequestMapping( method = RequestMethod.PUT )
  public void create( @RequestBody BookReference reference ) {
    
  }
  
  @RequestMapping( value = "/{id}", method = RequestMethod.GET )
  public BookReference retrieve( @PathVariable Long id ) {
    return null;
  }
  
  @RequestMapping( method = RequestMethod.GET )
  public List<BookReference> list() {
    return null;
  }
  
  @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
  public void delete( @PathVariable Long id ) {
    
  }
  
  @RequestMapping( value = "/{id}", method = RequestMethod.PUT )
  public void update( @PathVariable Long id  ) {
    
  }
  
}
