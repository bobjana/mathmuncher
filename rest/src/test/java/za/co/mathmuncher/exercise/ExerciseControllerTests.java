package za.co.mathmuncher.exercise;

import org.junit.Test;
import org.mockito.Matchers;
import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import za.co.mathmuncher.exercise.template.ExerciseTemplate;
import za.co.mathmuncher.exercise.template.ExerciseTemplateRepository;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class ExerciseControllerTests {

    @Test
    public void testStart() throws Exception {
        //GIVEN
        ExerciseTemplateRepository exerciseTemplateRepository = Mockito.mock(ExerciseTemplateRepository.class);
        ExerciseTemplate exerciseTemplate = new ExerciseTemplate(Type.MULTIPLICATION, 3);
        Mockito.when(exerciseTemplateRepository.findByType(Type.MULTIPLICATION)).thenReturn(exerciseTemplate);
        ExerciseService exerciseService = Mockito.mock(ExerciseService.class);
        Mockito.when(exerciseService.generate(exerciseTemplate)).thenReturn(new Exercise());
        ExerciseController exerciseController = new ExerciseController(exerciseService, exerciseTemplateRepository);
        //WHEN
        Exercise result = exerciseController.start(Type.MULTIPLICATION);
        //THEN
        assertNotNull(result);
        assertNotNull(result.getStartDate());
        Mockito.verify(exerciseTemplateRepository).findByType(Type.MULTIPLICATION);
        Mockito.verify(exerciseService).generate(Mockito.any(ExerciseTemplate.class));
    }
}
