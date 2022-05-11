package CodeV1;

import CodeV1.Robot;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotTest {
    protected Robot Rb;

    @BeforeEach
    void setUp() throws Exception{
        Rb = new Robot();
    }
    @AfterEach
    public void tearDown() throws Exception{
        Rb = null;
    }

    @Test
    void test1c (){
        Rb.setCapacitee(5);
        Rb.setSoute(0);
        Rb.setCapaciteeExtraction(1);
        int val = Rb.getStock();
        int cpE = Rb.getCapaciteeExtraction();
        Rb.recolter();
        assertEquals(val+cpE, Rb.getStock());
    }

    @Test
    void test2c (){
        Rb.setCapacitee(5);
        Rb.setSoute(4);
        Rb.setCapaciteeExtraction(2);
        int val = Rb.getStock();
        int cpE = Rb.getCapaciteeExtraction();
        Rb.recolter();
        assertEquals(val+cpE, Rb.getStock());
    }
}