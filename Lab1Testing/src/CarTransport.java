import org.w3c.dom.events.EventException;

import java.awt.*;
import java.util.*;

public class CarTransport extends Scania {

    /**
     * En konstruktor för Scania biltransport generellt med undernämnda parametrar
     *
     * @param nrDoors
     * @param color
     * @param enginePower
     */

    public CarTransport(int nrDoors, Color color, double enginePower, int maxCars, int x, int y) {
        super(nrDoors, color, enginePower);
        //settar bilen y-värden bangar hårdkodningen
        setX(x);
        setY(y);
        this.maxCars = maxCars;
        modelName= "CarHauler Extreme 720";
        setCurrentdirection("north");
    }
    private Integer maxCars;
    private ArrayList<Car> loadedcars = new ArrayList<>();
    public Integer getNrLoadedCars() {
        return loadedcars.size();
    }
    //alla extendar car så getX och getY finns i Car klassen
    public void addLoadedCars(Car bil){
        setRampDown();
        if(Math.abs(getX()-bil.getX())<=3 && Math.abs(getY()-bil.getY())<=3) {//bilen rimligt nära biltransporten
            if(!(bil instanceof Scania)) { //kanske vi ska hitta ett sätt att inte ladda på en cartransport på en cartransport
                if(!loadedcars.contains(bil)) {//men problemet är då att då kan vi inte lasta på någon långtradare
                    if (getAngleTrBed() == 70) { //rampen måste vara nere
                        loadedcars.add(bil);
                        bil.setX(this.getX());
                        bil.setY(this.getY());
                    }
                }
            }else{
                throw new IllegalFormatFlagsException("Make sure you are not loading a truck");
            }
        }
        else{
            throw new IllegalArgumentException("Make sure you are nearby the car you're trying to load");
        }
    }

    public String toString(int plats)  {
    ////Den här modellnamen vill vi ha till det specifika namnet på bilen.
    if(loadedcars.get(plats)==null){
       throw new RuntimeException("Platsen är tom");


     }
      return  loadedcars.get(plats).modelName + " är lastad på plats nummer: " + plats;
     }

    public void removeFromloadedcars(){
        if(getAngleTrBed() == 70) {
            if(loadedcars.size()>0){
                Car furthestOutCar = loadedcars.get(loadedcars.size()-1);
                furthestOutCar.setX(this.getX()+loadedcars.size()-1);
                loadedcars.remove(loadedcars.size()-1);
            }
        }
    }

    public void lastaAvAllaBilar(){
        for (int i = loadedcars.size()-1; i >-1; i-- ){
            removeFromloadedcars();
        }
    }

    public void setRampUp() {
        setAngleTrBed(0);
    }

    public void setRampDown() {
        setAngleTrBed(70);
    }

    //scania är super av cartransport, scania har funktionerna att man inte
    //får flytta om flaket är uppe!
    //this är i det här fallet transport bilen
    @Override
    public void move(){
        super.move();

        for(Car car : loadedcars){
            car.setX(this.getX());
            car.setY(this.getY());
        }
    }
}
