package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.Array.SingleNumber.Java;

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
        int[] nums = {4,1,2,1,2};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 4;
            int actual = Solution.singleNumber(nums);
            assertEquals(expected, actual);
        });
    }
}