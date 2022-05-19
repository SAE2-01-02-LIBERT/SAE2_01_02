package CodeS2_02;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MIneTest {

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
    void test1(){
        Rbor.setCapaciteeExtraction(0);
        mine.setStock(55);
        assertEquals(55,mine.getStock());
    }
    @Test
    void test2(){
        Rbor.setCapaciteeExtraction(3);
        mine.setStock(55);
        mine.estRecoltee(Rbor.getCapaciteeExtraction());
        assertEquals(55-3,mine.getStock());
    }

    @Test
    void test3(){
        Rbor.setCapaciteeExtraction(3);
        mine.setStock(0);
        mine.estRecoltee(Rbor.getCapaciteeExtraction());
        assertEquals(0,mine.getStock());
    }
}

