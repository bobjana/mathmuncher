package za.co.mathmuncher.exercise;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class WormGenerator {

    private HistoricalRandomGenerator generator = new HistoricalRandomGenerator();
    private WormGenerationConfig wormGenerationConfig;

    public WormGenerator() {
        this.wormGenerationConfig = new WormGenerationConfig();
    }

    public Worm generate() {
        return generate(initContext());
    }

    public List<Worm> generate(int numberOfWorms) {
        List<Worm> results = new ArrayList<Worm>();
        Map<String, List> context = initContext();
        for (int i = 0; i < numberOfWorms; i++) {
            results.add(generate(context));
        }
        return results;
    }

    private Worm generate(Map<String, List> context) {
        Worm worm = new Worm();
        worm.setHead(generateHead(context));
        worm.setName(generateName(context));
        int[] nodes = new int[5];
        for (int i = 0; i < nodes.length; i++) {
            generateNode(nodes, i, context);
        }
        worm.setNodes(nodes);
        return worm;
    }

    private int generateHead(Map<String, List> history) {
        int head = generateNumber(wormGenerationConfig.getHeadRange(), history.get("head"));
        history.get("head").add(head);
        return head;
    }

    private void generateNode(int[] nodes, int index, Map<String, List> history) {
        nodes[index] = generateNumber(wormGenerationConfig.getNodeRange(index), history.get("node" + index));
        history.get("node" + index).add(nodes[index]);
    }

    private String generateName(Map<String, List> context) {
        String[] range = wormGenerationConfig.getNameRange();
        String result = generator.generate(range, context.get("name"));
        context.get("name").add(result);
        return result;
    }

    private int generateNumber(int[] range, List<Integer> history) {
        int start = range[0];
        int end = range[range.length - 1];
        return generator.generate(start, end, history);
    }

    private Map<String, List> initContext() {
        Map<String, List> previousData = new HashMap<String, List>();
        previousData.put("head", new ArrayList());
        previousData.put("name", new ArrayList());
        previousData.put("node0", new ArrayList());
        previousData.put("node1", new ArrayList());
        previousData.put("node2", new ArrayList());
        previousData.put("node3", new ArrayList());
        previousData.put("node4", new ArrayList());
        return previousData;
    }
}
