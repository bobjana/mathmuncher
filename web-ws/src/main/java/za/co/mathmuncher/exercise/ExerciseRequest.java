
package za.co.mathmuncher.exercise;

public abstract class ExerciseRequest
{
    private ExerciseType type;

    public ExerciseRequest(ExerciseType type) {
        this.type = type;
    }

    public ExerciseRequest(){}

    public ExerciseType getType() {
        return type;
    }

}
