import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>(); // här har jag ta bort kommentaren

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        cc.cars.add(new Volvo240());
        //cc.cars.getFirst().startEngine();
        cc.cars.getFirst().currentSpeed = 0;
        cc.cars.getFirst().direction = "East";
        //cc.cars.getLast().stopEngine();


        //CarController bb = new CarController();
        cc.cars.add(new Saab95());
        //cc.cars.getLast().startEngine();
        cc.cars.getLast().direction = "East";
        //bb.cars.getLast().stopEngine();


        //CarController ss = new CarController();
        cc.cars.add(new Scania());
        // cc.cars.getLast().startEngine();
        cc.cars.getLast().direction = "East";
        //bb.cars.getLast().stopEngine();

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                car.move();
                int x = (int) Math.round(car.x);
                int y = (int) Math.round(car.y);
                frame.drawPanel.moveit(x, y, car);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            System.out.println("hello");
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars){
            car.brake(brake);
        }
    }

    void turboOn(){
        for (Vehicle car : cars){
            System.out.println("jjjjjj");
            if (car instanceof Saab95 saab95) {
                System.out.println("ssss");
                saab95.setTurboOn();
            }
        }
    }

    void turboOf(){
        for (Vehicle car : cars){
            if (car instanceof Saab95 saab95) {
                saab95.setTurboOff();
            }
        }
    }

    void liftButton(double angle){
        for (Vehicle car : cars){
            if (car instanceof Scania scania){
                scania.increaseTipping(angle);
            }
        }
    }
    void lowerButton(double angle){
        for (Vehicle car : cars){
            if (car instanceof Scania scania){
                scania.decreaseTipping(angle);
            }
        }
    }
    void startButton(){
        for (Vehicle car :cars) {
            car.startEngine();
        }
    }
    void stopButton(){
        for (Vehicle car :cars) {
            car.stopEngine();
        }
    }
}
