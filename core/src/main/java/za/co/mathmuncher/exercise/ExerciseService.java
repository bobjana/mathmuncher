package za.co.mathmuncher.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.mathmuncher.exercise.template.ClusterTemplate;
import za.co.mathmuncher.exercise.template.ClusterTemplateRespository;
import za.co.mathmuncher.exercise.template.ExerciseTemplate;

import java.util.*;

@Service
public class ExerciseService {

    private ClusterTemplateRespository clusterTemplateRespository;

    @Autowired
    public ExerciseService(ClusterTemplateRespository clusterTemplateRespository){
        this.clusterTemplateRespository = clusterTemplateRespository;
    }

    public Exercise generate(ExerciseTemplate exerciseTemplate){
        Exercise exercise = new Exercise();
        exercise.setClusters(generateClusterQuestions(exerciseTemplate));
        exercise.setType(exerciseTemplate.getType());
        return exercise;
    }

    private List<Cluster> generateClusterQuestions(ExerciseTemplate exerciseTemplate) {
        List<Cluster> questions = new ArrayList<Cluster>();
        ClusterTemplate clusterTemplate = clusterTemplateRespository.findByType(exerciseTemplate.getType());
        List<Integer> previousModifiers = new ArrayList<Integer>();
        for (int i = 0; i < exerciseTemplate.getNumberOfClusterQuestions();i++){
            Cluster cluster = generateRandomCluster(clusterTemplate, previousModifiers);
            previousModifiers.add(cluster.getModifier());
            questions.add(cluster);
        }
        return questions;
    }

    private Cluster generateRandomCluster(ClusterTemplate clusterTemplate, List<Integer> previousModifiers){
        //TODO: Implement RandomClusterGenerator
        return new Cluster(Arrays.asList(new Integer[]{1,2,3}),8);
    }

}
