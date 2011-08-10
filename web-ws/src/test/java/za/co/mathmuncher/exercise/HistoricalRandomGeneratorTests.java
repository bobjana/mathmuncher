package za.co.mathmuncher.exercise;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HistoricalRandomGeneratorTests {

    @Test
    public void testGenerate_OnlyOneUniqueNumberLeft() throws Exception {
        //GIVEN
        HistoricalRandomGenerator generator = new HistoricalRandomGenerator();
        //WHEN
        int result = generator.generate(2,6, Arrays.asList(new Integer[]{2,3,5,6}));
        //THEN
        assertEquals(4,result);
    }

    @Test
    public void testGenerate_LessNumbersInRangeThanHistoricalNumberAlreadyGenerated() throws Exception {
        //GIVEN
        HistoricalRandomGenerator generator = new HistoricalRandomGenerator();
        //WHEN
        int result = generator.generate(2,4, Arrays.asList(new Integer[]{2,3,4,3,4}));
        //THEN
        assertEquals(2,result);
    }

    @Test
    public void testGenerate_RangeOnly2Numbers_HistoryAlreadyContainsNumbers() throws Exception {
        //GIVEN
        HistoricalRandomGenerator generator = new HistoricalRandomGenerator();
        //WHEN
        int result = generator.generate(2,3, Arrays.asList(new Integer[]{2,3,2}));
        //THEN
        assertEquals(3,result);
    }

    @Test
    public void testGenerate_RangeOnly2Numbers_EmptyHistory() throws Exception {
        //GIVEN
        HistoricalRandomGenerator generator = new HistoricalRandomGenerator();
        //WHEN
        int result = generator.generate(2,3, Arrays.asList(new Integer[]{}));
        //THEN
        assertTrue(result == 2 || result == 3);
    }


}
