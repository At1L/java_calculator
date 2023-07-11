import org.example.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest {
    @Test
    void NplusTest(){
        Main.Num temp1 = new Main.Num("1");
        Main.Num temp2 = new Main.Num("1");
        Main.Num temp3 = new Main.Num();
        Main.calculations("+", temp1, temp2, temp3);
        assertEquals("2", Main.getAnswer(temp3));
    }
    @Test
    void RplusTest(){
        Main.Num temp1 = new Main.Num("1/2");
        Main.Num temp2 = new Main.Num("1/2");
        Main.Num temp3 = new Main.Num();
        Main.calculations("+", temp1, temp2, temp3);
        assertEquals("1", Main.getAnswer(temp3));
    }
}
