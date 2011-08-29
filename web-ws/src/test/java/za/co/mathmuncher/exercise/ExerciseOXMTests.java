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
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:META-INF/spring/oxm-config.xml")
public class ExerciseOXMTests {

    private static final String ANTHROPOD_REQUEST_TEMPLATE = "anthropodExerciseRequest.xml";
    private static final String ANTHROPOD_RESPONSE_TEMPLATE = "anthropodExercise.xml";
    private static final String WORM_REQUEST_TEMPLATE = "wormExerciseRequest.xml";
    private static final String WORM_RESPONSE_TEMPLATE = "wormExercise.xml";

    @Autowired
    private CastorMarshaller castorMarshaller;

    @Test
    public void marshallAnthropodExerciseRequest() throws Exception {
        //GIVEN
        AnthropodExerciseRequest request = new AnthropodExerciseRequest(ExerciseType.MULTIPLICATION);
        StringResult sr = new StringResult();
        //WHEN
        castorMarshaller.marshal(request, sr);
        //THEN
        assertXMLTheSame(loadTemplate(ANTHROPOD_REQUEST_TEMPLATE), sr.toString());
    }

    @Test
    public void unmarshallAnthropodExerciseRequest() throws Exception {
        //GIVEN
        String template = loadTemplate(ANTHROPOD_REQUEST_TEMPLATE);
        //WHEN
        Object result = castorMarshaller.unmarshal(new StringSource(template));
        //THEN
        assertTrue(result instanceof ExerciseRequest);
        AnthropodExerciseRequest request = (AnthropodExerciseRequest) result;
        assertEquals(ExerciseType.MULTIPLICATION, request.getType());
    }

    @Test
    public void marshallAnthropodExerciseResponse() throws Exception {
        //GIVEN
        AnthropodExerciseResponse response = new AnthropodExerciseResponse();
        response.setType(ExerciseType.MULTIPLICATION);
        List<Anthropod> anthropods = new ArrayList<Anthropod>();
        anthropods.add(createAnthropod("A",3,"[2,1,5,9,6]"));
        anthropods.add(createAnthropod("B",5,"[2,3,4,5,6]"));
        anthropods.add(createAnthropod("C",6,"[9,8,7,6,5]"));
        anthropods.add(createAnthropod("D",7,"[2,4,6,8,9]"));
        response.setAnthropods(anthropods);
        StringResult sr = new StringResult();
        //WHEN
        castorMarshaller.marshal(response, sr);
        //THEN
        assertXMLTheSame(loadTemplate(ANTHROPOD_RESPONSE_TEMPLATE), sr.toString());
    }

    @Test
    public void unmarshallExerciseResponse() throws Exception {
        //GIVEN
        String template = loadTemplate(ANTHROPOD_RESPONSE_TEMPLATE);
        //WHEN
        Object result = castorMarshaller.unmarshal(new StringSource(template));
        //THEN
        assertTrue(result instanceof AnthropodExerciseResponse);
        AnthropodExerciseResponse reponse = (AnthropodExerciseResponse) result;
        assertEquals(ExerciseType.MULTIPLICATION, reponse.getType());
        assertEquals(4, reponse.getAnthropods().size());
        Anthropod first = reponse.getAnthropods().get(0);
        assertEquals(new Integer(3), new Integer(first.getBody()));
    }

    @Test
    public void marshallWormExerciseRequest() throws Exception {
        //GIVEN
        WormExerciseRequest request = new WormExerciseRequest(ExerciseType.MULTIPLICATION);
        StringResult sr = new StringResult();
        //WHEN
        castorMarshaller.marshal(request, sr);
        //THEN
        assertXMLTheSame(loadTemplate(WORM_REQUEST_TEMPLATE), sr.toString());
    }

    @Test
    public void unmarshallWormExerciseRequest() throws Exception {
        //GIVEN
        String template = loadTemplate(WORM_REQUEST_TEMPLATE);
        //WHEN
        Object result = castorMarshaller.unmarshal(new StringSource(template));
        //THEN
        assertTrue(result instanceof WormExerciseRequest);
        WormExerciseRequest request = (WormExerciseRequest) result;
        assertEquals(ExerciseType.MULTIPLICATION, request.getType());
    }

    @Test
    public void marshallWormExerciseResponse() throws Exception {
        //GIVEN
        WormExerciseResponse response = new WormExerciseResponse();
        response.setType(ExerciseType.MULTIPLICATION);
        List<Worm> worms = new ArrayList<Worm>();
        worms.add(createWorm("A",2,new int[]{2,1,5,9,6}));
        worms.add(createWorm("B",1,new int[]{2,3,4,5,6}));
        worms.add(createWorm("C",5,new int[]{2,1,5,9,6}));
        worms.add(createWorm("D",3,new int[]{2,1,5,9,6}));
        response.setWorms(worms);
        StringResult sr = new StringResult();
        //WHEN
        castorMarshaller.marshal(response, sr);
        //THEN
        assertXMLTheSame(loadTemplate(ANTHROPOD_RESPONSE_TEMPLATE), sr.toString());
    }

    @Test
     public void unmarshallWormExerciseResponse() throws Exception {
        //GIVEN
        String template = loadTemplate(WORM_RESPONSE_TEMPLATE);
        //WHEN
        Object result = castorMarshaller.unmarshal(new StringSource(template));
        //THEN
        assertTrue(result instanceof WormExerciseResponse);
        WormExerciseResponse reponse = (WormExerciseResponse) result;
        assertEquals(ExerciseType.MULTIPLICATION, reponse.getType());
        assertEquals(4, reponse.getWorms().size());
        Worm first = reponse.getWorms().get(0);
        assertEquals(new Integer(2), first.getHead());
        assertEquals("A", first.getName());
        assertEquals(Arrays.toString(new int[]{2,3,4,5,6}), Arrays.toString(first.getNodes()));
    }

    private Anthropod createAnthropod(String name, int body, String legs) {
        Anthropod anthropod = new Anthropod();
        anthropod.setName(name);
        anthropod.setBody(body);
        anthropod.setLegs(legs);
        return anthropod;
    }

    private Worm createWorm(String name, int head, int[] nodes) {
        Worm worm = new Worm();
        worm.setName(name);
        worm.setHead(head);
        worm.setNodes(nodes);
        return worm;
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
