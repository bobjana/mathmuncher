package za.co.mathmuncher.template;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import za.co.mathmuncher.exercise.template.ExerciseTemplate;
import za.co.mathmuncher.exercise.template.ExerciseTemplateRepository;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/spring/applicationContext.xml")
@Transactional
public class ExerciseTemplateRepositoryTests {

    @Autowired
    ExerciseTemplateRepository exerciseTemplateRepository;

    @Test
    public void testSave() {
        assertNotNull(exerciseTemplateRepository);
        Assert.assertEquals(0, exerciseTemplateRepository.count());
        exerciseTemplateRepository.save(new ExerciseTemplate(Type.MULTIPLICATION,3));
        Assert.assertEquals(1, exerciseTemplateRepository.count());
    }

    @Test
    public void testFindBy() {
        exerciseTemplateRepository.save(new ExerciseTemplate(Type.DIVISION,3));
        assertNotNull(exerciseTemplateRepository.findByType(Type.DIVISION));
        assertNull(exerciseTemplateRepository.findByType(Type.ADDITION));
    }

}
