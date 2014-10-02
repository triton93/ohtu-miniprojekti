
package tomate.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tomate.component.BibTexFormatter;
import tomate.domain.Reference;
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
  public Reference createOrUpdate( @RequestBody Reference reference ) {
    return this.referenceRepository.save( reference );
  }
  
  @RequestMapping( value = "/{id}", method = RequestMethod.GET )
  public Reference retrieve( @PathVariable Long id ) {
    return this.referenceRepository.findOne( id );
  }
  
  @RequestMapping( method = RequestMethod.GET )
  public List<Reference> list() {
    return this.referenceRepository.findAll();
  }
  
  @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
  public Reference delete( @PathVariable Long id ) {
    
    Reference reference = this.referenceRepository.findOne( id );
    this.referenceRepository.delete( reference ); 
    
    return reference;
  }
  
}
