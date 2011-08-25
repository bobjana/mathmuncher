package za.co.mathmuncher.exercise;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Takes history of previously generated values into account and tries to randomize numbers based on
 * half of size of list or range of numbers, whichever is smaller.
 */
@Component
public class HistoricalRandomGenerator {

    private Random randomGenerator = new Random();

    public int generate(int start, int end, List<Integer> previousNumbers) {
        assert end > start;
        assert end > 0;
        assert start >= 0;
        int sizeOfRange = end - start + 1;
        int sizeOfHistory = previousNumbers.size();
        int generated = -1;
        if (sizeOfRange > sizeOfHistory) {
            generated = obtainRandomNumber(start, end, previousNumbers);
        } else {
            //Obtain latest half of previous numbers
            if (sizeOfHistory >= 2) {
                sizeOfHistory = new Double(Math.round(new Double(sizeOfHistory) / 2)).intValue();
            }
            generated = obtainRandomNumber(start, end, getLatest(previousNumbers, sizeOfHistory));
        }
        return generated;
    }

    public String generate(String[] range, List<String> previous) {
        List<Integer> previousNamesAsNumbers = convertPreviousNamesAsNumbers(range, previous);
        //Zero indexed, hence range.length-1
        int nameAsNumber = generate(0, range.length -1, previousNamesAsNumbers);
        return range[nameAsNumber];
    }

    private int obtainRandomNumber(int start, int end, List<Integer> previousNumbers) {
        int generated = start;
        int attempt = 0;
        while (true && attempt++ < 100) {
            generated = randomGenerator.nextInt(end + 1);
            if (!previousNumbers.contains(generated) && generated >= start && generated <= end) {
                break;
            }
        }
        if (generated >= start && generated <= end) {
            return generated;
        }
        return start;
    }

    private List<Integer> getLatest(List<Integer> previousNumbers, int latestHalfCount) {
        List<Integer> result = new ArrayList<Integer>();
        int index = latestHalfCount;
        if (index == 0) {
            return previousNumbers;
        }
        for (int i = index; i < previousNumbers.size(); i++) {
            result.add(previousNumbers.get(i));
        }
        return result;
    }

    private List<Integer> convertPreviousNamesAsNumbers(String[] range, List<String> previous) {
        Map<String, Integer> mapping = new HashMap<String, Integer>();
        for (int i = 0; i < range.length; i++) {
            mapping.put(range[i], i);
        }
        List<Integer> result = new ArrayList<Integer>();
        for (String previousName : previous) {
            result.add(mapping.get(previousName));
        }
        return result;
    }

}
