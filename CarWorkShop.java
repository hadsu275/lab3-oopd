import java.util.ArrayList;
public class CarWorkShop<T extends PersonalCar> {

    protected final ArrayList<T> carsIn;
    protected final int maxCapacity;

    public CarWorkShop(int maxCapacity) {
        this.carsIn = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }

    public void bringCar(T car){
        if (carsIn.size() < maxCapacity) {
            carsIn.add(car);
        }
        else{
            throw new IllegalArgumentException("det är fullt i verkstaden");
        }
    }

    public void returnCar() {
        if (carsIn.isEmpty()) {
            throw new IllegalStateException("Det finns inga bilar att hämta!");
        }
        carsIn.remove(0);
    }

    public ArrayList<T> getCarsIn(){
        return new ArrayList<>(carsIn);
    }
}
