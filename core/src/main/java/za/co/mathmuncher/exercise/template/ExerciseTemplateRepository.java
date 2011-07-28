package za.co.mathmuncher.exercise.template;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.mathmuncher.exercise.Type;

@Repository
public interface ExerciseTemplateRepository extends JpaRepository<ExerciseTemplate, Long> {

    ExerciseTemplate findByType(Type type);

}
