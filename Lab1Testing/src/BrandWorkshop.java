import java.util.HashMap;

public class BrandWorkshop implements Workshop {
    protected BrandWorkshop(int maxCars, String brand){
        this.maxCars=maxCars;
        this.brand=brand;

    }

    public int getMaxCars() {
        return maxCars;
    }

    public void setMaxCars(int maxCars) {
        this.maxCars = maxCars;
    }

    private int maxCars;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    private String brand;

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
        if(bil.modelName.contains(getBrand())) {
            if (carsInWorkshop.size() < getMaxCars()) {
                carsInWorkshop.put(plats, bil);
            }
            else{
                throw new IllegalArgumentException("The workshop only has: " + getMaxCars() + " so for the moment it's full");
            }
        }
        else{
            throw new IllegalArgumentException("This workshop only works on cars that are of the: " + getBrand()+ " brand");
        }
    }

    @Override
    public void removeCar(int plats ) {
        System.out.println(carsInWorkshop.get(plats).modelName + " på plats: " +plats + " har lämnats ut");
        carsInWorkshop.remove(plats);

    }



}
