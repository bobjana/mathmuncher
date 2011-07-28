package za.co.mathmuncher.exercise.template;

import za.co.mathmuncher.Entity;
import za.co.mathmuncher.exercise.Type;

@javax.persistence.Entity
public class ExerciseTemplate extends Entity {

    private Type type;
    private int numberOfClusterQuestions;

    ExerciseTemplate(){}

    public ExerciseTemplate(Type type, int numberOfClusterQuestions) {
        this.type = type;
        this.numberOfClusterQuestions = numberOfClusterQuestions;
    }

    public Type getType() {
        return type;
    }

    public int getNumberOfClusterQuestions() {
        return numberOfClusterQuestions;
    }
}
