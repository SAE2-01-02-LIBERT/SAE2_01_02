package CodeV1;

import CodeV1.Robot;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

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
    void InfCapacite (){
        Rb.setCapacitee(5);
        Rb.setSoute(0);
        Rb.setCapaciteeExtraction(1);
        int val = Rb.getStock();
        int cpE = Rb.getCapaciteeExtraction();
        Rb.recolter();
        assertEquals(val+cpE, Rb.getStock());
    }

    @Test
    void SupCapacite (){
        Rb.setCapacitee(5);
        Rb.setSoute(4);
        Rb.setCapaciteeExtraction(2);
        int val = Rb.getStock();
        int cpE = Rb.getCapaciteeExtraction();
        Rb.recolter();
        assertNotEquals(val+cpE, Rb.getStock());
    }

    @Test
    void CapSouteEgal (){
        Rb.setCapacitee(5);
        Rb.setSoute(5);
        Rb.setCapaciteeExtraction(1);
        int val = Rb.getStock();
        Rb.recolter();
        assertEquals(val, Rb.getStock());
    }
}