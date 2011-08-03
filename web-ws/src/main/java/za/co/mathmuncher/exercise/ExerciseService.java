package za.co.mathmuncher.exercise;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
=======
import org.springframework.stereotype.Service;
import za.co.mathmuncher.domain.AnthropodExerciseResponse;

import java.util.Arrays;
import java.util.Random;
>>>>>>> 6d93613508186c0495c5e6ac54afb58de122804d

@Service
public class ExerciseService {

<<<<<<< HEAD
    private HistoricalRandomGenerator randomGenerator;

    @Autowired
    public ExerciseService(HistoricalRandomGenerator historicalRandomGenerator){
        this.randomGenerator = historicalRandomGenerator;
    }

    public AnthropodExercise generateAnthropodExercise(za.co.mathmuncher.exercise.ExerciseType type) {
        //TODO: Grab settings from a config file for type and currently logged in user
        int numberOfLegs = 5;
        int numberOfQuestions = 4;

        AnthropodExercise response = new AnthropodExercise();
        response.setType(type);
        List<Integer> previousBodies = new ArrayList<Integer>();
        for (int i = 0; i < numberOfQuestions; i++){
            AnthropodExercise.Anthropod anthropod = new AnthropodExercise.Anthropod();
            int body = randomGenerator.generate(2,12,previousBodies);
            previousBodies.add(body);
            anthropod.setBody(body);
            anthropod.setLegs(generateLegs(numberOfLegs));
            response.getAnthropods().add(anthropod);
=======
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
>>>>>>> 6d93613508186c0495c5e6ac54afb58de122804d
        }
        return response;
    }

    private String generateLegs(int numberOfLegs) {
<<<<<<< HEAD
        List<Integer> previousLegs = new ArrayList<Integer>();
        int[] result = new int[numberOfLegs];
        for (int i = 0;i < numberOfLegs; i++){
            int leg =  randomGenerator.generate(2,12,previousLegs);
            previousLegs.add(leg);
            result[i] = leg;
        }
        return Arrays.toString(result);
=======
        Random randomGenerator = new Random();
        String[] legs = new String[numberOfLegs];
        for (int i = 0; i < numberOfLegs; i++) {
            legs[i] = "" + randomGenerator.nextInt(12);
        }
        return Arrays.toString(legs);
>>>>>>> 6d93613508186c0495c5e6ac54afb58de122804d
    }
}
