import java.awt.*;

public class Volvo240 extends PersonalCar {

    public final static double trimFactor = 1.25;

    public Volvo240(){
        super(4, 100, "Volvo240", Color.black );
        this.direction = "South";

    }
     public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}