package tomate.controller;

import java.lang.ref.Reference;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tomate.Application;
import tomate.domain.BookReference;
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
//    @Autowired
//    private Reference testirefe;
    @Autowired
    private Reference re;

    @Before
    public void setUp() {

    }

    @Test
    public void retrieveReference() {

        BookReference re = new BookReference();
        re.setAuthors("pinja kiiskinen");
        re.setPublisher("riku tuominen");
        re.setTitle("future is here");
        re.setYear(2015);

        referepo.save(re);

        Long id = Long.valueOf("1");

        tomate.domain.Reference testirefe = referepo.findOne(id);

        assertNotNull(testirefe);
        assertEquals(re, testirefe);
    }

}
