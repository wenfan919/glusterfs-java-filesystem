package objectstack.repository;

import junit.framework.TestCase;
import objectstack.repository.impl.GlusterfsRepository;
import org.junit.Test;

/**
 * @author <a href="mailto:tangfx128@gmail.com">tangfeixiong</a>
 */
public class GlusterfsRepositoryTest extends TestCase {

    @Test
    public void testGetProvider() {
        GlusterfsRepository.getProvider("gluster");
    }
}
