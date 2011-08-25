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


    @Test
    public void testGenerate_AnyName_EmptyHistory() throws Exception {
        //GIVEN
        HistoricalRandomGenerator generator = new HistoricalRandomGenerator();
        //WHEN
        String result = generator.generate(new String[]{"A","B"}, Arrays.asList(new String[]{}));
        //THEN
        assertTrue(result.equals("A") || result.equals("B"));
    }

    @Test
    public void testGenerate_Only1NameLeft() throws Exception {
        //GIVEN
        HistoricalRandomGenerator generator = new HistoricalRandomGenerator();
        //WHEN
        String result = generator.generate(new String[]{"A","B"}, Arrays.asList(new String[]{"B"}));
        //THEN
        assertEquals("A",result);
    }

    @Test
    public void testGenerate_NameInBottom50percent() throws Exception {
        //GIVEN
        HistoricalRandomGenerator generator = new HistoricalRandomGenerator();
        //WHEN
        String result = generator.generate(new String[]{"A","B","C","D"}, Arrays.asList(new String[]{"A","B","C","D","A","B"}));
        //THEN
        assertTrue(result.equals("C") || result.equals("D"));
    }

    @Test
    public void testGenerate_NameInBottom50percent_Only1NameLeftInBottom50percent() throws Exception {
        //GIVEN
        HistoricalRandomGenerator generator = new HistoricalRandomGenerator();
        //WHEN
        String result = generator.generate(new String[]{"A","B","C","D"}, Arrays.asList(new String[]{"A","B","C","D","A","B","C"}));
        //THEN
        assertEquals("D",result);
    }

}
