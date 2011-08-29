package za.co.mathmuncher.exercise;

import java.util.ArrayList;
import java.util.List;

public class WormExerciseResponse extends ExerciseResponse {

    private List<Worm> worms = new ArrayList<Worm>();

    public List<Worm> getWorms() {
        return worms;
    }

    public void setWorms(List<Worm> worms) {
        this.worms = worms;
    }

}
