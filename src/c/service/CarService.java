package c.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import c.common.ConnectionFactory;
import c.model.dao.CarDao;
import c.model.vo.Car;
import c.model.vo.Rent;

public class CarService {
    ConnectionFactory factory;
    public CarService() {
        factory = ConnectionFactory.getInstance();
    }
    public ArrayList<Car> selectAllCar(){
        Connection conn = null;
        ArrayList<Car> list = null;

        try {
            conn = factory.createConnection();
            list = new CarDao().selectAllCar(conn);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            factory.close(conn);
        }
        return list;
    }

    public int insertCar(Car car) {
        Connection conn = null;
        int result = 0;
        try {
            conn = factory.createConnection();
            result = new CarDao().insertCar(car, conn);
            if(result > 0) {
                factory.commit(conn);
            } else {
                factory.rollback(conn);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            factory.close(conn);
        }

        return result;
    }
    public int deleteCar(String carId) {
        Connection conn = null;
        int result = 0;
        try {
            conn = factory.createConnection();
            result = new CarDao().deleteCar(carId, conn);
            if(result > 0) {
                factory.commit(conn);
            } else {
                factory.rollback(conn);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            factory.close(conn);
        }
        return result;
    }

}
