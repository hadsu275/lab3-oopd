import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IvecoTest {

    @Test
    void testStartLoadMode() {
        Iveco iveco = new Iveco();
        iveco.currentSpeed = 1;
        assertThrows(IllegalArgumentException.class, iveco::startLoadMode);
    }

    @Test
    void testExitLoadMode() {
        Iveco iveco = new Iveco();
        iveco.startLoadMode();
        iveco.exitLoadMode();
        assertFalse(iveco.getLoadMode());
    }

    @Test
    void testSetRampDown() {
        Iveco iveco = new Iveco();
        iveco.startLoadMode();
        iveco.setRampDown();
        assertFalse(iveco.getIsRampUp());
    }

    @Test
    void testSetRampUp() {
        Iveco iveco = new Iveco();
        iveco.startLoadMode();
        iveco.setRampDown();
        assertFalse(iveco.getIsRampUp());
        iveco.setRampUp();
        assertTrue(iveco.getIsRampUp());
    }

    @Test
    void testLoadCar() {
        Iveco iveco = new Iveco();
        Saab95 saab = new Saab95();
        assertTrue(iveco.getIsRampUp());
        iveco.startLoadMode();
        iveco.setRampDown();
        iveco.setFairDistance(false);
        assertThrows(IllegalArgumentException.class, () -> iveco.loadCar(saab));
        iveco.setFairDistance(true);
        iveco.loadCar(saab);
        assertFalse(iveco.getLoadedCars().isEmpty());
    }

    @Test
    void testUnloadCar() {
        Iveco iveco = new Iveco();
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        iveco.startLoadMode();
        iveco.setRampDown();
        assertTrue(iveco.getFairDistance());
        iveco.loadCar(saab);
        iveco.loadCar(volvo);
        assertEquals(2, iveco.getLoadedCars().size());
        assertSame(saab, iveco.getLoadedCars().getFirst());
        assertSame(volvo, iveco.getLoadedCars().getLast());
        iveco.unloadCar();
        assertEquals(1, iveco.getLoadedCars().size());
        assertSame(saab, iveco.getLoadedCars().getLast());

    }

    @Test
    void testGetLoadedCars() {
        Iveco iveco = new Iveco();
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();


        iveco.startLoadMode();
        iveco.setRampDown();
        //Scania scania = new Scania();
        //assertThrows(IllegalArgumentException.class, () -> iveco.loadCar(scania));
        // Ta bort utkommenteringarna så ser man att det inte går att lasta en Scania på Ivecon
        iveco.loadCar(volvo);
        iveco.loadCar(saab);
        iveco.loadCar(volvo);
        iveco.loadCar(saab);
        assertThrows(IllegalArgumentException.class, () -> iveco.loadCar(saab));
        assertEquals(iveco.getLoadedCars(), iveco.getLoadedCars());
    }
}