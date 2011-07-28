package za.co.mathmuncher.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.co.mathmuncher.exercise.Type;
import za.co.mathmuncher.exercise.template.ExerciseTemplate;
import za.co.mathmuncher.exercise.template.ExerciseTemplateRepository;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ExerciseTemplateRepository exerciseTemplateRepository;

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() != null) {
			return;
		}

        exerciseTemplateRepository.save(new ExerciseTemplate(Type.MULTIPLICATION,3));
	}
}
