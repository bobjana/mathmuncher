package za.co.mathmuncher.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ExerciseService {

    private HistoricalRandomGenerator randomGenerator;

    @Autowired
    public ExerciseService(HistoricalRandomGenerator historicalRandomGenerator){
        this.randomGenerator = historicalRandomGenerator;
    }

    public AnthropodExerciseResponse generateAnthropodExercise(ExerciseType type) {
        //TODO: Grab settings from a config file for type and currently logged in user
        int numberOfLegs = 5;
        int numberOfQuestions = 4;

        AnthropodExerciseResponse response = new AnthropodExerciseResponse();
        response.setType(type);
        List<Integer> previousBodies = new ArrayList<Integer>();
        for (int i = 0; i < numberOfQuestions; i++){
            AnthropodExerciseResponse.Anthropod anthropod = new AnthropodExerciseResponse.Anthropod();
            int body = randomGenerator.generate(2,12,previousBodies);
            previousBodies.add(body);
            anthropod.setBody(body);
            anthropod.setLegs(generateLegs(numberOfLegs));
            response.getAnthropods().add(anthropod);
        }
        return response;
    }

    private String generateLegs(int numberOfLegs) {
        List<Integer> previousLegs = new ArrayList<Integer>();
        int[] result = new int[numberOfLegs];
        for (int i = 0;i < numberOfLegs; i++){
            int leg =  randomGenerator.generate(2,12,previousLegs);
            previousLegs.add(leg);
            result[i] = leg;
        }
        return Arrays.toString(result);
    }
}
