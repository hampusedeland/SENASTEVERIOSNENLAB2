import java.util.ArrayList;

//när man skapar ArrayListen så anger vad typvariabeln är och det påverkar hela klassen
//C

    public class OrdinaryWorkshop<C extends Car>{
        private C carType; /*typparameter som extendar Car, bara bilar kan läggas till
        kan även ha en workshop som tar emot lastbil --> upperbound*/
        private ArrayList<C> loadedCars = new ArrayList<C>();
        //arraylist av typen C, defaultvärde
        private Integer maxCars;

        //konstruktorn ett argument, max cars
        public OrdinaryWorkshop(int maxCars) {
            this.maxCars = maxCars;
        }

        public void addToloadedCars(C bil){
            if (loadedCars.size() < maxCars) {
                loadedCars.add(bil);
            }
        }
public String removeFromLoadedCars(){
            if (loadedCars.size()>0){
                C furthestOutCar = loadedCars.get(loadedCars.size()-1);
                loadedCars.remove(loadedCars.size()-1);
                return (furthestOutCar.getClass().getName());
            }
            return "no cars";
        }
        public void lastaAvAllaBilar(){
            while (loadedCars.size()>0){
                removeFromLoadedCars();
            }
        }
public Integer getNumberOfLoadedCars(){
            return loadedCars.size();
        }


    }
