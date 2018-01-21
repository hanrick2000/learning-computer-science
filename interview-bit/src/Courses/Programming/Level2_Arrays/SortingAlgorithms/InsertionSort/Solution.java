package Courses.Programming.Level2_Arrays.SortingAlgorithms.InsertionSort;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> input = new ArrayList<Integer>();
        input.add(7);
        input.add(2);
        input.add(4);
        input.add(1);
        input.add(5);
        input.add(3);
        ArrayList<Integer> result = insertionSort(input);
        scan.close();
        System.out.println(result);
    }

    public static ArrayList<Integer> insertionSort(ArrayList<Integer> input) {
        for (int i=1; i<input.size(); i++){
            int value = input.get(i);
            int hole = i;
            while(hole>0 && input.get(hole-1)>value){
                input.set(hole, input.get(hole-1));
                hole = hole-1;
            }
            input.set(hole, value);
        }
        return input;
    }
}