package za.co.mathmuncher.exercise;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import za.co.mathmuncher.domain.AnthropodExerciseRequest;
import za.co.mathmuncher.domain.AnthropodExerciseResponse;
import za.co.mathmuncher.domain.ExerciseType;

@Endpoint
public class ExerciseEndpoint {

    private static final String NAMESPACE_URI = "http://mathmuncher.co.za/ws/schemas/ex";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "anthropodExerciseRequest")
    public @ResponsePayload
    AnthropodExerciseResponse handleGenerateAnthropodExercise(@RequestPayload AnthropodExerciseRequest anthropodExerciseRequest)
        throws Exception {
        System.out.println("Reached endpoint...." + anthropodExerciseRequest);
        AnthropodExerciseResponse response = new AnthropodExerciseResponse();
        response.setType(ExerciseType.MULTIPLICATION);

        AnthropodExerciseResponse.Anthropod anthropod = new AnthropodExerciseResponse.Anthropod();
        anthropod.setBody(6);
        anthropod.setLegs("[2,5,6,7,9]");
        response.getAnthropod().add(anthropod);

        AnthropodExerciseResponse.Anthropod anthropod2 = new AnthropodExerciseResponse.Anthropod();
        anthropod2.setBody(8);
        anthropod2.setLegs("[3,9,12,11,10]");
        response.getAnthropod().add(anthropod2);
        return response;
    }

}
