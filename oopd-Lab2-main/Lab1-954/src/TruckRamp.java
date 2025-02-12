import java.util.ArrayList;

public interface TruckRamp {
    void setRampDown();
    void setRampUp();
    boolean getIsRampUp();
    void startLoadMode();
    void exitLoadMode();
    boolean getLoadMode();
    void loadCar(PersonalCar personalCar);
    void setFairDistance(boolean boolDistance);
    boolean getFairDistance();
    void unloadCar();
    ArrayList<PersonalCar> getLoadedCars();
}
