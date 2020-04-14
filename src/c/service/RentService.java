package c.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import c.common.ConnectionFactory;
import c.model.dao.RentDao;
import c.model.vo.Rent;

public class RentService {
    ConnectionFactory factory;
    public RentService() {
        factory = ConnectionFactory.getInstance();
    }
    public ArrayList<Rent> selectRent(){
        Connection conn = null;
        ArrayList<Rent> list = null;
        try {
            conn = factory.createConnection();
            list = new RentDao().selectRent(conn);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            factory.close(conn);
        }
        return list;
    }
    public Rent memberSelectRent(String memberId){
        Connection conn = null;
        Rent rent = null;
        try {
            conn = factory.createConnection();
            rent = new RentDao().memberSelectRent(memberId, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            factory.close(conn);
        }
        return rent;
    }
    public int insertRent(Rent newRent) {
        int result = 0;
        Connection conn = null;

        try {
            conn = factory.createConnection();
            result = new RentDao().insertRent(newRent, conn);
            if(result > 0) {
                factory.commit(conn);
            } else {
                factory.rollback(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            factory.close(conn);
        }
        return result;
    }
}
