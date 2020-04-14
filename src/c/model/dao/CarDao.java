package c.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import c.common.ConnectionFactory;
import c.model.vo.Car;

public class CarDao {
    Properties prop;
    public CarDao() {
        prop = new Properties();
        try {
            prop.load(new FileReader("resources/query.properties"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public ArrayList<Car> selectAllCar(Connection conn) {
        ArrayList<Car> list = null;
        Statement stmt = null;
        ResultSet rset = null;
        String query = "SELECT * FROM CAR";
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
            list = new ArrayList<Car>();
            while(rset.next()) {
                Car car = new Car();
                car.setCarNo(rset.getInt("CAR_NO"));
                car.setCarId(rset.getString("CAR_ID"));
                car.setCarSize(rset.getString("CAR_SIZE"));
                car.setCarName(rset.getString("CAR_NAME"));
                car.setCarFuel(rset.getString("CAR_FUEL"));
                car.setCarCost(rset.getInt("CAR_COST"));
                list.add(car);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(stmt);
            ConnectionFactory.close(rset);
        }
        return list;
    }
    public int insertCar(Car car, Connection conn) {
        int result = 0;
        PreparedStatement pstmt = null;
        String query = prop.getProperty("insertCar");
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, car.getCarId());
            pstmt.setString(2, car.getCarSize());
            pstmt.setString(3, car.getCarName());
            pstmt.setString(4, car.getCarFuel());
            pstmt.setInt(5, car.getCarCost());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(pstmt);
        }
        return result;
    }

    public int deleteCar(String carId, Connection conn) {
        int result = 0;
        PreparedStatement pstmt = null;
        String query = prop.getProperty("deleteCar");

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, carId);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }
}
