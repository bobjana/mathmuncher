package za.co.mathmuncher.exercise;

import java.util.HashMap;
import java.util.Map;

public class WormGenerationConfig {

    private String[] nameRange;
    private int[] headRange;
    private Map<Integer, int[]> nodeRange = new HashMap<Integer, int[]>();

    public WormGenerationConfig() {
        headRange = new int[]{2, 3, 4};
        nameRange = new String[]{"A", "B", "C"};
        nodeRange.put(0, new int[]{2, 3, 4, 5, 6, 7, 8, 9});
        nodeRange.put(1, new int[]{2, 3, 4, 5});
        nodeRange.put(2, new int[]{2, 3, 4, 5});
        nodeRange.put(3, new int[]{0, 1, 2, 3});
        nodeRange.put(4, new int[]{0, 1, 2});
    }

    public int[] getHeadRange() {
        return headRange;
    }

    public void setHeadRange(int[] headRange) {
        this.headRange = headRange;
    }

    public int[] getNodeRange(int index) {
        return nodeRange.get(index);
    }

    public void setNode1Range(int index, int[] range) {
        this.nodeRange.put(index, range);
    }

    public String[] getNameRange() {
        return nameRange;
    }

    public void setNameRange(String[] nameRange) {
        this.nameRange = nameRange;
    }
}
