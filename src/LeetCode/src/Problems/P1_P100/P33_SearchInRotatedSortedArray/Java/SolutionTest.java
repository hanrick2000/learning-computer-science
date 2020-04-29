package LeetCode.src.Problems.P1_P100.P33_SearchInRotatedSortedArray.Java;

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
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 4;
            int actual = Solution.search(nums, target);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 3;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = -1;
            int actual = Solution.search(nums, target);
            assertEquals(expected, actual);
        });
    }
}