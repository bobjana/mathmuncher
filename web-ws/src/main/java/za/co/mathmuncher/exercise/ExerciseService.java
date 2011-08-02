package za.co.mathmuncher.exercise;

import org.springframework.stereotype.Service;
import za.co.mathmuncher.domain.AnthropodExerciseResponse;

import java.util.Arrays;
import java.util.Random;

@Service
public class ExerciseService {

    public AnthropodExerciseResponse generateAnthropodExercise(za.co.mathmuncher.domain.ExerciseType type) {
        int numberOfLegs = 5;
        int numberOfQuestions = 4;

        Random randomGenerator = new Random();
        AnthropodExerciseResponse response = new AnthropodExerciseResponse();
        response.setType(type);
        for (int i = 0; i < numberOfQuestions; i++) {
            AnthropodExerciseResponse.Anthropod anthropod = new AnthropodExerciseResponse.Anthropod();
            anthropod.setBody(randomGenerator.nextInt(12));
            anthropod.setLegs(generateLegs(numberOfLegs));
            response.getAnthropod().add(anthropod);
        }
        return response;
    }

    private String generateLegs(int numberOfLegs) {
        Random randomGenerator = new Random();
        String[] legs = new String[numberOfLegs];
        for (int i = 0; i < numberOfLegs; i++) {
            legs[i] = "" + randomGenerator.nextInt(12);
        }
        return Arrays.toString(legs);
    }
}
