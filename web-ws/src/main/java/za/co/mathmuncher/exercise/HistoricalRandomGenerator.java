package za.co.mathmuncher.exercise;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        assert start > 0;
        int sizeOfRange = end - start + 1;
        int sizeOfHistory = previousNumbers.size();
        int generated = -1;
        if (sizeOfRange > sizeOfHistory){
            generated = obtainRandomNumber(start, end, previousNumbers);
        }
        else{
            //Obtain latest half of previous numbers
            int lastestHalf = sizeOfHistory>=2?new Double(Math.round(new Double(sizeOfHistory)/2)).intValue():sizeOfHistory;
            generated = obtainRandomNumber(start, end, getLatest(previousNumbers, lastestHalf));

        }
        return generated;
    }

    private int obtainRandomNumber(int start, int end, List<Integer> previousNumbers) {
        int generated = start;
        int attempt = 0;
        while (true && attempt++ < 100){
           generated = randomGenerator.nextInt(end + 1);
           if (!previousNumbers.contains(generated) && generated >= start && generated <= end){
                break;
            }
        }
        if (generated >= start && generated <= end){
            return generated;
        }
        return start;
    }

    private List<Integer> getLatest(List<Integer> previousNumbers, int latestHalfCount) {
        List<Integer> result = new ArrayList<Integer>();
        int index = latestHalfCount;
        if (index == 0){
           return previousNumbers;
        }
        for (int i = index; i < previousNumbers.size(); i++){
            result.add(previousNumbers.get(i));
        }
        return result;
    }
}
