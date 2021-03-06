package ElementsOfProgrammingInterviews.src.Book.C6_Arrays.Q9_PermuteElementsOfArray.Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationArray1 {
    public static void applyPermutation(List<Integer> perm, List<Integer> A){
        for(int i=0; i<A.size(); ++i){
            // Check if the element at index i has not been moved by checking if
            // perm.get(i) is non-negative.
            int next=i;
            while(perm.get(next) >= 0){
                Collections.swap(A, i, perm.get(next));
                int temp = perm.get(next);
                // Subtracts perm.size() from an entry in perm to make it negative,
                // while indicates the corresponding move has been performed.
                perm.set(next, perm.get(next) - perm.size());
                next = temp;
            }
        }

        // Restore perm.
        for (int i=0; i<perm.size(); i++){
            perm.set(i, perm.get(i)+perm.size());
        }
    }

    public static void main(String[] args){
        List<Integer> A = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        perm.add(3);
        perm.add(1);
        perm.add(2);
        perm.add(0);
        applyPermutation(perm, A);
    }
}
