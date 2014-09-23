
package tomate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tomate.domain.BookReference;
import tomate.domain.Reference;
import tomate.repository.ReferenceRepository;

/**
 *
 * @author Toni Oksanen
 */

@RestController
@RequestMapping( "/api" )
public class ReferenceController {
  
  @Autowired
  private ReferenceRepository referenceRepository;
  
  @RequestMapping( "/references" )
  public Reference findReference() {
    
    // testataan jenkinssiä
    
    return new BookReference();
    
    
    
    
  }
  
  
}
