package LeetCode.src.Explore.Interview.GoogleInterview.ArraysAndStrings.TrappingRainWater.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 6;
            int actual = Solution.trap(height);
            assertEquals(expected, actual);
        });
    }
}