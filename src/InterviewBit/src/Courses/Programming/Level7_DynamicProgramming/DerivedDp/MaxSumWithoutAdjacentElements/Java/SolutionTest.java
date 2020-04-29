package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.DerivedDp.MaxSumWithoutAdjacentElements.Java;

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
        int[][] A = {{1, 2, 3, 4}, {2, 3, 4, 5}};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 8;
            int actual = Solution.adjacent(A);
            assertEquals(expected, actual);
        });
    }
}