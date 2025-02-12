import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    @Test
    void testGetTippingAngle() {
        Scania scania = new Scania();
        scania.increaseTipping(40);
        assertEquals(40, scania.getTippingAngle());
    }

    @Test
    void testIncreaseTipping() {
        Scania scania = new Scania();
        scania.increaseTipping(5);
        assertEquals(5, scania.getTippingAngle());
    }

    @Test
    void testDecreaseTipping() {
        Scania scania = new Scania();
        scania.increaseTipping(50);
        scania.decreaseTipping(5);
        assertEquals(45, scania.getTippingAngle());
    }

    @Test
    void move() {
        Scania scania = new Scania();
        scania.increaseTipping(40);
        assertThrows(IllegalArgumentException.class, scania::move);
    }
}
