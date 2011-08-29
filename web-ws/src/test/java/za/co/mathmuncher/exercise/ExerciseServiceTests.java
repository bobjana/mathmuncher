package za.co.mathmuncher.exercise;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ExerciseServiceTests {

    @Test
    public void testGenerateWormExercise() throws Exception {
        //GIVEN
        HistoricalRandomGenerator generator = Mockito.mock(HistoricalRandomGenerator.class);
        WormGenerator wormGenerator = Mockito.mock(WormGenerator.class);
        ExerciseService exerciseService = new ExerciseService(generator, wormGenerator);
        //WHEN
        ExerciseResponse result = exerciseService.generateWormExercise(ExerciseType.MULTIPLICATION);
        //THEN
        assertThat("Type of exercise",result.getType(), is(ExerciseType.MULTIPLICATION));
        verify(wormGenerator,times(4)).generate();
    }
}
