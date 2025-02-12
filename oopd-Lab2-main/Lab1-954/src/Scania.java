import java.awt.*;
public class Scania extends Vehicle implements TruckBed{
    private double tippingAngle;
    private final double maxTippingAngel = 70.0;

    //public final static double trimFactor = 1.50;

    public Scania() {
        super(2, 150,"Scania", Color.white);
    }
    public double speedFactor(){
        return enginePower * 0.01;
    }

    @Override
    public double getTippingAngle(){
        return tippingAngle;
    }

    @Override
    public void increaseTipping(double angle) {
        if (getCurrentSpeed() != 0){
            throw new IllegalArgumentException("det går inte tippa när man kör");
        }
        if (angle < 0){
            throw new IllegalArgumentException("Angel kan inte var minder än noll");
        }

        tippingAngle = Math.min(tippingAngle + angle, maxTippingAngel );
    }

    @Override
    public void decreaseTipping(double angle){
        if (getCurrentSpeed() != 0){
            throw new IllegalArgumentException("det går inte tippa när man kör");
        }
        if (angle < 0){
            throw new IllegalArgumentException("Angel kan inte var minder än noll");
        }
        tippingAngle = Math.max(tippingAngle - angle, 0 );
    }

    @Override
    public void move(){
        if (tippingAngle > 0){
            throw new IllegalArgumentException("lastbilen ska inte kunna köra om flaket är uppfällt.");
        }
        super.move();
    }


}

