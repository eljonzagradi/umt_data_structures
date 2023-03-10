package data_structure_warm_up;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProblemSet1 {

    public static ArrayList<String> findUnique(String[] list) {

        ArrayList<String> newList = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {

            if (!newList.contains(list[i])) {
                newList.add(list[i]);
            }
        }
        return newList;
    }

    public static ArrayList<Integer> findEven(int[] list) {

        ArrayList<Integer> newList = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {

            if (list[i] % 2 == 0) {
                newList.add(list[i]);
            }
        }
        return newList;
    }

    public static int findKthSmallest(Integer[] list, int k) {
        List<Integer> newList = Arrays.asList(list);
        Collections.sort(newList);
        return newList.get(k-1);
    }

    public static ArrayList<Integer> longestSequence(int[] list) {
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            if (i == 0) {
                newList.add(list[0]);
            } else {
                if (list[i] > newList.get(newList.size() - 1)) {
                    newList.add(list[i]);
                }
            }
        }
        return newList;
    }

    public static ArrayList<Integer> longestConsecutiveSequences(int[] list) {
        ArrayList<ArrayList<Integer>> sequences = new ArrayList<>();
        ArrayList<Integer> currentSequence = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {
            if (i == 0) {
                currentSequence.add(list[0]);
            } else {
                if (list[i] - list[i - 1] == 1) {
                    currentSequence.add(list[i]);
                } else {
                    if (currentSequence.size() > 1) {
                        sequences.add(currentSequence);
                    }
                    currentSequence = new ArrayList<>();
                    currentSequence.add(list[i]);
                }
            }
        }
        if (currentSequence.size() > 1) {
            sequences.add(currentSequence);
        }

        int maxLength = 0, inx = 0;
        for (ArrayList<Integer> sequence : sequences) {
            if (sequence.size() > maxLength) {
                maxLength = sequence.size();
                inx = sequences.indexOf(sequence);
            } else if (sequence.size() == maxLength) {
                if (sequence.get(0) > sequences.get(inx).get(0)) {
                    inx = sequences.indexOf(sequence);
                }
            }
        }
        return sequences.get(inx);
    }
}