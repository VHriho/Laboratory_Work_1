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

    @Test
    public void Test_2(){
        assertEquals(3, StrCalculator.add("0,1,2"));
        assertEquals(6, StrCalculator.add("1,2,3"));
        assertEquals(10, StrCalculator.add("1,2,3,4"));
        assertEquals(60, StrCalculator.add("10,20,30"));
    }
}