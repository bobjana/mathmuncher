package za.co.mathmuncher.exercise;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class WormGeneratorTests {

    @Test
    public void testGenerate() throws Exception {
        //GIVEN
        WormGenerator wormGenerator = new WormGenerator();
        //WHEN
        Worm result = wormGenerator.generate();
        //THEN
        assertNotNull(result.getName());
        assertTrue(result.getHead() >= 2 && result.getHead() <= 4);
        assertEquals(5, result.getNodes().length);
        assertTrue(result.getNodes()[0] >= 2 && result.getNodes()[0] <= 9);
        assertTrue(result.getNodes()[1] >= 2 && result.getNodes()[1] <= 5);
        assertTrue(result.getNodes()[2] >= 2 && result.getNodes()[2] <= 5);
        assertTrue(result.getNodes()[3] >= 0 && result.getNodes()[3] <= 3);
        assertTrue(result.getNodes()[4] >= 0 && result.getNodes()[4] <= 2);
    }

    @Test
    public void testGenerateMultiples() throws Exception {
        //GIVEN
        WormGenerator wormGenerator = new WormGenerator();
        //WHEN
        List<Worm> result = wormGenerator.generate(4);
        //THEN
        assertEquals(4, result.size());
    }
}
