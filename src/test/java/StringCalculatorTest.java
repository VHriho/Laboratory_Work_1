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

    @Test
    public void Test_3(){
        assertEquals(6, StrCalculator.add("1\n2,3"));
        assertEquals(6, StrCalculator.add("1\n2\n3"));
        assertEquals(15, StrCalculator.add("1\n2\n3\n4\n5"));
        try{
            StrCalculator.add("1,\n");
        }
        catch(RuntimeException e){
            assertEquals("INPUT INCORRECT! contains invalid: \\n", e.getMessage());
        }
        try{
            StrCalculator.add("\n,1");
        }
        catch(RuntimeException e){
            assertEquals("INPUT INCORRECT! contains invalid: \\n", e.getMessage());
        }
    }

    @Test
    public void Test_4(){
        assertEquals(3, StrCalculator.add("//;\n1;2"));
        assertEquals(6, StrCalculator.add("//;\n1;2;3"));
        assertEquals(6, StrCalculator.add("//;\n1;2\n3"));
        assertEquals(15, StrCalculator.add("//-\n1-2-3-4-5"));
        try{
            StrCalculator.add("//;\n1#2");
        }
        catch(RuntimeException e){
            assertEquals("INPUT INCORRECT! contains invalid: delimiter", e.getMessage());
        }
        try{
            StrCalculator.add("//-\n-1-2");
        }
        catch(RuntimeException e){
            assertEquals("INPUT INCORRECT! contains invalid: delimiter", e.getMessage());
        }
    }

    @Test
    public void Test_5(){
        try{
            StrCalculator.add("-1,-2");
        }
        catch(RuntimeException e){
            assertEquals("INPUT INCORRECT! contains: negative [-1, -2]", e.getMessage());
        }
        try{
            StrCalculator.add("-1,1,-1");
        }
        catch(RuntimeException e){
            assertEquals("INPUT INCORRECT! contains: negative [-1, -1]", e.getMessage());
        }
        try{
            StrCalculator.add("-1,1\n-1");
        }
        catch(RuntimeException e){
            assertEquals("INPUT INCORRECT! contains: negative [-1, -1]", e.getMessage());
        }
        try{
            StrCalculator.add("//;\n-1;-2");
        }
        catch(RuntimeException e){
            assertEquals("INPUT INCORRECT! contains: negative [-1, -2]", e.getMessage());
        }
    }
}