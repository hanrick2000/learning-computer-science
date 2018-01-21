package Courses.Programming.Level3_BinarySearch.Examples.RotatedArray;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.*;
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
        List<Integer> input = Arrays.asList(4, 5, 6, 7, 0, 1, 2);
        assertTimeout(Duration.ofMillis(200), () -> {
            int expected = 0;
            int actual = Solution.findMin(input);
            assertEquals(expected, actual);
        });
    }
}