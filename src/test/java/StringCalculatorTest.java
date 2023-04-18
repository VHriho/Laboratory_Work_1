import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator StrCalculator = new StringCalculator();

    @Test
    public void Test_1(){
        assertEquals(0, StrCalculator.add(""));
        assertEquals(1, StrCalculator.add("1"));
        assertEquals(3, StrCalculator.add("1,2"));
    }
}