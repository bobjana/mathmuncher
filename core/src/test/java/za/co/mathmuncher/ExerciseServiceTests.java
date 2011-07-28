package za.co.mathmuncher;

import org.junit.Test;
import org.mockito.Mockito;
import za.co.mathmuncher.exercise.Exercise;
import za.co.mathmuncher.exercise.ExerciseService;
import za.co.mathmuncher.exercise.Type;
import za.co.mathmuncher.exercise.template.ClusterTemplate;
import za.co.mathmuncher.exercise.template.ClusterTemplateRespository;
import za.co.mathmuncher.exercise.template.ExerciseTemplate;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExerciseServiceTests{

    @Test
    public void generate(){
        //GIVEN
        ClusterTemplateRespository clusterTemplateRespository = Mockito.mock(ClusterTemplateRespository.class);
        List<Integer> allowedModifiers = Arrays.asList(new Integer[]{7,8,9});
        List<Integer> allowedNodes = Arrays.asList(new Integer[]{1,2,3,4,5});
        Type type = Type.MULTIPLICATION;
        Mockito.when(clusterTemplateRespository.findByType(type)).thenReturn(new ClusterTemplate(type, allowedModifiers,
            allowedNodes));
        ExerciseService exerciseService = new ExerciseService(clusterTemplateRespository);
        ExerciseTemplate exerciseTemplate = new ExerciseTemplate(type,3);
        //WHEN
        Exercise exercise = exerciseService.generate(exerciseTemplate);
        //THEN
        assertThat("Number of cluster questions",exercise.getClusters().size(),is(3));
        assertThat("Type of exercise",exercise.getType(),is(type));
    }
}
