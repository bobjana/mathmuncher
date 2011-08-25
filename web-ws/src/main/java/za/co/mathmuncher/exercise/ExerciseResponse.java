
package za.co.mathmuncher.exercise;

import java.util.ArrayList;
import java.util.List;

public class ExerciseResponse {

    private List<Anthropod> anthropods = new ArrayList<Anthropod>();
    private ExerciseType type;

    public List<Anthropod> getAnthropods() {
        return anthropods;
    }

    public void setAnthropods(List<Anthropod> list) {
        anthropods = list;
    }

    public ExerciseType getType() {
        return type;
    }

    public void setType(ExerciseType type) {
        this.type = type;
    }

}
