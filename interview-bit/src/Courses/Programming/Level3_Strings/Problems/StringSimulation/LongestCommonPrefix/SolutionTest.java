package Courses.Programming.Level3_Strings.Problems.StringSimulation.LongestCommonPrefix;

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
        String[] input = new String[] {"abcdefgh", "aefghijk", "abcefgh"};  
        assertTimeout(Duration.ofMillis(200), () -> {
            String expected = "a";
            String actual = Solution.longestCommonPrefix(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {           
        String[] input = new String[] {"ABCD"};
        assertTimeout(Duration.ofMillis(200), () -> {
            String expected = "ABCD";
            String actual = Solution.longestCommonPrefix(input);
            assertEquals(expected, actual);
        });
    }
}