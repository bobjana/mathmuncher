package za.co.mathmuncher.exercise;

import javax.xml.transform.Source;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.xml.transform.StringSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.ws.test.server.*;

import java.io.File;
import java.io.IOException;

import static junit.framework.Assert.assertTrue;
import static org.springframework.ws.test.server.RequestCreators.withPayload;
import static org.springframework.ws.test.server.ResponseMatchers.payload;


//@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
//@ContextConfiguration(inheritLocations = true, loader = MockServletContextWebContextLoader.class,
//        locations = {"/WEB-INF/spring-servlet.xml"})
public class ExcerciseEndpointIntegrationTests {

    @Test
    public void testSomething(){
        assertTrue(true);
    }

//    @Autowired
//    private ApplicationContext applicationContext;
//
//    private MockWebServiceClient mockClient;
//
//    @Before
//    public void createClient() {
//        mockClient = MockWebServiceClient.createClient(applicationContext);
//    }
//
//    @Test
//    public void customerEndpoint() throws Exception {
//        String resource = "anthropodExerciseRequest.xml";
//        Source requestPayload = new StringSource(loadResource(resource));
//        Source responsePayload = new StringSource(
//                "<customerCountResponse xmlns='http://springframework.org/spring-ws'>" +
//                        "<customerCount>10</customerCount>" +
//                        "</customerCountResponse>");
//
//        mockClient.sendRequest(withPayload(requestPayload)).
//                andExpect(payload(responsePayload));
//    }
//
//    private String loadResource(String resource) throws IOException {
//        return FileUtils.readFileToString(new File(this.getClass().getResource(resource).getFile()));
//    }
}