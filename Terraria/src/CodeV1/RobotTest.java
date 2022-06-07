package CodeV1;

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
        mine.setCapacite(1);
        mine.setStock(1);
        Rbor.recolter(mine);
        assertEquals(1, Rbor.getStock());
        System.out.println(Rbor.getStock());
    }
    @Test
    void test2 (){
        Rbor.setCapacitee(9);
        Rbor.setSoute(3);
        Rbor.setCapaciteeExtraction(4);
        mine.setCapacite(50);
        mine.setStock(0);
        Rbor.recolter(mine);
        assertEquals(3, Rbor.getStock());
    }
    @Test
    void test3 (){
        Rbor.setType("Ni");
        Rbor.setCapacitee(5);
        Rbor.setSoute(5);
        Rbor.setCapaciteeExtraction(3);
        mine.setCapacite(25);
        mine.setStock(25);
        Rbor.recolter(mine);
        assertEquals(5, Rbor.getStock());
    }
    @Test
    void test4 (){
        Rbor.setCapacitee(6);
        Rbor.setSoute(0);
        Rbor.setCapaciteeExtraction(1);
        mine.setStock(2);
        mine.setCapacite(50);
        Rbor.recolter(mine);
        assertEquals(1, Rbor.getStock());
        System.out.println(Rbor.getStock());
    }
}