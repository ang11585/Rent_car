package c.model.vo;

public class Car {
    private int carNo;
    private String carId;
    private String carSize;
    private String carName;
    private String carFuel;
    private int carCost;

    public Car() {}

    public int getCarNo() {
        return carNo;
    }

    public void setCarNo(int carNo) {
        this.carNo = carNo;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarSize() {
        return carSize;
    }

    public void setCarSize(String carSize) {
        this.carSize = carSize;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarFuel() {
        return carFuel;
    }

    public void setCarFuel(String carFuel) {
        this.carFuel = carFuel;
    }

    public int getCarCost() {
        return carCost;
    }

    public void setCarCost(int carCost) {
        this.carCost = carCost;
    }

    @Override
    public String toString() {
        return
                this.carNo + ", " +
                this.carId + ", " +
                this.carSize + ", " +
                this.carName + ", " +
                this.carFuel + ", " +
                this.carCost ;
    }
}
