import java.util.ArrayList;



    public class OrdinaryWorkshop<C extends Car>{
        private C carType;
        private ArrayList<C> loadedCars;
        private Integer maxCars;

        public OrdinaryWorkshop(int maxCars) {
            this.maxCars = maxCars;
        }


    }
