package CodeV1;

import CodeV1.Robot;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotTest {
    protected Robot Rb;

    @BeforeAll
    void setUp() throws Exception{
      Robot Rb = new Robot();
    }
    @AfterAll
    public void tearDown() throws Exception{
        Rb = null;
    }

    @Test
    void test1c (){
        Robot Rb = new Robot(); // la c'est bizare
        Rb.setCapacitee(5);
        Rb.setSoute(0);
        Rb.setCapaciteeExtraction(1);
        int val = Rb.getStock();
        int cpE = Rb.getCapaciteeExtraction();
        Rb.recolter();

        assertEquals(val+cpE, Rb.getStock());
        }
    }
