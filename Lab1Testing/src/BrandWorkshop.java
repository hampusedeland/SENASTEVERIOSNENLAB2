import java.util.HashMap;

public class BrandWorkshop implements Workshop {
    protected BrandWorkshop(int maxCars){
        
    }

    public int getMaxCars() {
        return maxCars;
    }

    public void setMaxCars(int maxCars) {
        this.maxCars = maxCars;
    }

    private int maxCars;

    public HashMap<Integer, Car> getCarsInWorkshop() {
        return carsInWorkshop;
    }

    public void setCarsInWorkshop(HashMap<Integer, Car> carsInWorkshop) {
        this.carsInWorkshop = carsInWorkshop;
    }

    private HashMap<Integer, Car> carsInWorkshop = new HashMap<>();
    public void checkBrandCorrect(Car bil){

    }
    @Override
    public void addCar(int plats, Car bil) {
        carsInWorkshop.put(plats, bil);
    }

    @Override
    public void removeCar(int plats ) {
        carsInWorkshop.remove(plats);
    }



}
