package za.co.mathmuncher.exercise;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.castor.CastorMarshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:META-INF/spring/oxm-config.xml")
public class AnthropodExerciseOXMTests {

    private static final String REQUEST_TEMPLATE = "anthropodExerciseRequest.xml";
    private static final String RESPONSE_TEMPLATE = "anthropodExercise.xml";

    @Autowired
    private CastorMarshaller castorMarshaller;

    @Test
    public void marshallExerciseRequest() throws Exception {
        //GIVEN
        AnthropodExerciseRequest request = new AnthropodExerciseRequest(ExerciseType.MULTIPLICATION);
        StringResult sr = new StringResult();
        //WHEN
        castorMarshaller.marshal(request, sr);
        //THEN
        assertXMLTheSame(loadTemplate(REQUEST_TEMPLATE), sr.toString());
    }

    @Test
    public void unmarshallExerciseRequest() throws Exception {
        //GIVEN
        String template = loadTemplate(REQUEST_TEMPLATE);
        //WHEN
        Object result = castorMarshaller.unmarshal(new StringSource(template));
        //THEN
        assertTrue(result instanceof AnthropodExerciseRequest);
        AnthropodExerciseRequest request = (AnthropodExerciseRequest) result;
        assertEquals(ExerciseType.MULTIPLICATION, request.getType());
    }

    @Test
    public void marshallExerciseResponse() throws Exception {
        //GIVEN
        AnthropodExercise response = new AnthropodExercise();
        response.setType(ExerciseType.MULTIPLICATION);
        List<AnthropodExercise.Anthropod> anthropods = new ArrayList<AnthropodExercise.Anthropod>();
        anthropods.add(createAnthropod(3,"[2,1,5,9,6]"));
        anthropods.add(createAnthropod(5,"[2,3,4,5,6]"));
        anthropods.add(createAnthropod(6,"[9,8,7,6,5]"));
        anthropods.add(createAnthropod(7,"[2,4,6,8,9]"));
        response.setAnthropods(anthropods);
        StringResult sr = new StringResult();
        //WHEN
        castorMarshaller.marshal(response, sr);
        //THEN
        assertXMLTheSame(loadTemplate(RESPONSE_TEMPLATE), sr.toString());
    }

    @Test
    public void unmarshallExerciseResponse() throws Exception {
        //GIVEN
        String template = loadTemplate(RESPONSE_TEMPLATE);
        //WHEN
        Object result = castorMarshaller.unmarshal(new StringSource(template));
        //THEN
        assertTrue(result instanceof AnthropodExercise);
        AnthropodExercise reponse = (AnthropodExercise) result;
        assertEquals(ExerciseType.MULTIPLICATION, reponse.getType());
        assertEquals(4, reponse.getAnthropods().size());
        AnthropodExercise.Anthropod first = reponse.getAnthropods().get(0);
        assertEquals(new Integer(3), new Integer(first.getBody()));
    }

    private AnthropodExercise.Anthropod createAnthropod(int body, String legs) {
        AnthropodExercise.Anthropod anthropod = new AnthropodExercise.Anthropod();
        anthropod.setBody(body);
        anthropod.setLegs(legs);
        return anthropod;
    }

    private String loadTemplate(String template) throws Exception {
        return FileUtils.readFileToString(new File(this.getClass().getResource(template).getFile()));
    }

    private void assertXMLTheSame(String expected, String result) throws IOException {
        expected = StringUtils.trimToEmpty(expected);
        expected = StringUtils.replace(expected, "\t", "");
        expected = StringUtils.replace(expected, "\r\n", "");
        result = StringUtils.trimToEmpty(result);
        result = StringUtils.replace(expected, "\t", "");
        result = StringUtils.replace(expected, "\r\n", "");
        assertEquals(expected, result);
    }
}
