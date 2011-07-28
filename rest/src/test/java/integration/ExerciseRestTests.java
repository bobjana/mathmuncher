package integration;

import com.alibaba.fastjson.JSON;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.tidy.Tidy;
import za.co.mathmuncher.exercise.Exercise;
import za.co.mathmuncher.exercise.Type;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExerciseRestTests {

    @Test
    @Ignore
    public void testStart() throws Exception {
        ///GIVEN
        GetMethod request = new GetMethod("http://localhost:8080/matchmuncher/exercise/start/MULTIPLICATION");
        HttpClient client = getHttpClient();

        request.setDoAuthentication(true);
        request.addRequestHeader("Content-Type", "application/json");
        request.getParams().setBooleanParameter(HttpMethodParams.USE_EXPECT_CONTINUE, true);
        //WHEN
        String response = executeRestService(request, client);
        //THEN
        Exercise exercise = JSON.parseObject(response,Exercise.class);
        assertEquals(exercise.getType(), Type.MULTIPLICATION);
        assertNotNull(exercise.getClusters());
        assertEquals(exercise.getClusters().size(), 3);
    }

    private String executeRestService(GetMethod request, HttpClient client) throws IOException {
        client.executeMethod(request);
        int returnCode = request.getStatusCode();
        assertThat("Status code", request.getStatusCode(),is(200));
        String response = request.getResponseBodyAsString();
        if (!response.startsWith("{")){
            Tidy tidy = new Tidy();
            tidy.setXHTML(false);
            tidy.setQuiet(true);
            tidy.parse(new ByteArrayInputStream(request.getResponseBody()), System.err);
        }else{
            System.out.println(response);
        }
        return response;
    }

    private HttpClient getHttpClient() {
        HttpClient client = new HttpClient();
        client.getParams().setAuthenticationPreemptive(true);
        client.getHttpConnectionManager().getParams().setConnectionTimeout(10000);
        client.getState().setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("admin", "admin"));
        return client;
    }

}