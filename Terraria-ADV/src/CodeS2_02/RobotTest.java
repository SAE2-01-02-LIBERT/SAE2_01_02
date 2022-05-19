package CodeS2_02;

import CodeV1.Robot;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest { //converture de condition de Robot pour la methode recolter
    private Robot Rbor;
    private Mine mine;

    @BeforeEach
    void setUp() throws Exception{
        Rbor = new Robot("OR",1);
        mine = new Mine("OR",1);
    }
    @AfterEach
    public void tearDown() throws Exception{
        Rbor = null;
        mine = null;
    }
    @Test
    void test1 (){
        Rbor.setCapacitee(6);
        Rbor.setSoute(0);
        Rbor.setCapaciteeExtraction(1);
        Rbor.recolter(mine);
        assertEquals(1, Rbor.getStock());
    }
    @Test
    void test2 (){
        Rbor.setCapacitee(6);
        Rbor.setSoute(4);
        Rbor.setCapaciteeExtraction(2);
        Rbor.recolter(mine);
        assertEquals(6, Rbor.getStock());
    }
    @Test
    void test3 (){
        Rbor.setCapacitee(6);
        Rbor.setSoute(5);
        Rbor.setCapaciteeExtraction(3);
        Rbor.recolter(mine);
        assertEquals(6, Rbor.getStock());
    }
    @Test
    void test4 (){
        Rbor.setCapacitee(6);
        Rbor.setSoute(6);
        Rbor.setCapaciteeExtraction(3);
        Rbor.recolter(mine);
        assertEquals(6, Rbor.getStock());
    }
}