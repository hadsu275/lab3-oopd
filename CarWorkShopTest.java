import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarWorkShopTest {

    @Test
    void testBringCar() {
        CarWorkShop<PersonalCar> carWorkShop = new CarWorkShop<>(2);
        Volvo240 volvo = new Volvo240();
        Saab95 saab95 = new Saab95();
        carWorkShop.bringCar(volvo);
        carWorkShop.bringCar(saab95);
        assertEquals(2, carWorkShop.getCarsIn().size());
    }

    @Test
    void testReturnCar() {
        CarWorkShop<PersonalCar> carWorkShop = new CarWorkShop<>(2);
        Volvo240 volvo = new Volvo240();
        Saab95 saab95 = new Saab95();
        carWorkShop.bringCar(volvo);
        carWorkShop.bringCar(saab95);
        carWorkShop.returnCar();
        carWorkShop.returnCar();
        assertEquals(0,carWorkShop.getCarsIn().size());
    }

    @Test
    void testGetCarsIn() {
        CarWorkShop<PersonalCar> carWorkShop = new CarWorkShop<>(2);
        Volvo240 volvo = new Volvo240();
        Saab95 saab95 = new Saab95();
        carWorkShop.bringCar(volvo);
        carWorkShop.bringCar(saab95);
        assertEquals(2, carWorkShop.getCarsIn().size());
    }
    @Test
    void testVolvoWorkShop(){
        CarWorkShop<Volvo240> carWorkShop = new CarWorkShop<>(2);
        Volvo240 volvo = new Volvo240();
        carWorkShop.bringCar(volvo);
        assertEquals(1, carWorkShop.getCarsIn().size());
        //Saab95 saab95 = new Saab95();
        //assertThrows(IllegalArgumentException.class, () -> carWorkShop.bringCar(saab95));
        // Ta bort utkommenteringarna så ser man att man inte kan lägga till en saab i en volvo-specifik workshop


    }

}