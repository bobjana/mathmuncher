package za.co.mathmuncher.exercise.template;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClusterTemplateRespository extends JpaRepository<ClusterTemplate, Long> {

    ClusterTemplate findByType(Type type);

}
