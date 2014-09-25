package tomate.controller;


import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tomate.Application;
import tomate.domain.Reference;
import tomate.repository.ReferenceRepository;

/**
 *
 * @author Toni Oksanen
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ReferenceControllerTest {

    @Autowired
    private ReferenceController referenceController;
    @Autowired
    private ReferenceRepository referepo;

    @Test
    public void retrieveReference() {
        referepo.deleteAll();
        Reference ref = new Reference();
        ref.setAuthors("jukka");
        ref.setPublisher("pekka");
        ref.setTitle("erkki");
        ref.setYear(2000);
        referepo.save(ref);

        Reference retrievedRef = referenceController.retrieve(ref.getId());
        
        assertEquals(1, referepo.count());
        assertEquals(retrievedRef, referepo.findOne(ref.getId()));
    
    }
    
    @Test
    public void repositorySaves() {
        referepo.deleteAll();
        Reference ref = new Reference();
        ref.setAuthors("jukka");
        ref.setPublisher("pekka");
        ref.setTitle("erkki");
        ref.setYear(2000);
        
        Reference savedRef = referenceController.createOrUpdate(ref);
 
        assertNotNull(referepo.count());
        assertEquals(savedRef, referepo.findOne(ref.getId()));
    }

    @Test
    public void listingAllReferences(){
        referepo.deleteAll();
        Reference ref = new Reference();
        ref.setAuthors("jukka");
        ref.setPublisher("pekka");
        ref.setTitle("erkki");
        ref.setYear(2000);
        referepo.save(ref);
        
        Reference ref1 = new Reference();
        ref1.setAuthors("jukka1");
        ref1.setPublisher("pekka1");
        ref1.setTitle("erkki1");
        ref1.setYear(2001);
        referepo.save(ref1);
        
        List<Reference> refs = new ArrayList<>();
        refs.add(ref); refs.add(ref1);
        
        assertEquals(refs, referenceController.list());
    }
    
    @Test
    public void deleteReferenceFromRepo(){
        referepo.deleteAll();
        Reference ref = new Reference();
        ref.setAuthors("jukka");
        ref.setPublisher("pekka");
        ref.setTitle("erkki");
        ref.setYear(2000);
        referepo.save(ref);
        
        Reference ref1 = new Reference();
        ref1.setAuthors("jukka1");
        ref1.setPublisher("pekka1");
        ref1.setTitle("erkki1");
        ref1.setYear(2001);
        referepo.save(ref1);
        
        Reference deletedRef = referenceController.delete(ref1.getId());
        
        assertEquals(1, referenceController.list().size());
        
        
    }
    
}
