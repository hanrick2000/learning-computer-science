package Courses.Programming.Level3_TwoPointers.Problems.Sorting.ThreeSum.Java;

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
    public void TrivialCase1() {
        int[] A = {-1, 2, 1, -4};
        int B = 1;
        assertTimeout(Duration.ofMillis(200), () -> {
            int expected = 2;
            int actual = Solution.threeSumClosest(A, B);
            assertEquals(expected, actual);
        });
    }
}