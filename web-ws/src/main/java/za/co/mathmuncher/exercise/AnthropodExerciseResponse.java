package za.co.mathmuncher.exercise;

import java.util.ArrayList;
import java.util.List;

public class AnthropodExerciseResponse extends ExerciseResponse {

    private List<Anthropod> anthropods = new ArrayList<Anthropod>();

    public List<Anthropod> getAnthropods() {
        return anthropods;
    }

    public void setAnthropods(List<Anthropod> list) {
        anthropods = list;
    }
}
