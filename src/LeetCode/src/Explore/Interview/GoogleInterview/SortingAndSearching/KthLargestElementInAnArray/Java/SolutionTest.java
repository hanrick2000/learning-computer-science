package LeetCode.src.Explore.Interview.GoogleInterview.SortingAndSearching.KthLargestElementInAnArray.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class SolutionTest {
    
    Solution solution;
    
    @BeforeEach
    public void setUp() throws Exception {
        solution = new Solution();
    }
    
    @AfterEach
    public void tearDown() throws Exception {
        solution = null;
    }
    
    @Test
    public void MainFunction() {
        assertTimeout(Duration.ofMillis(1000), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 4;
            int actual = Solution.findKthLargest(nums, k);
            assertEquals(expected, actual);
        });
    }
}