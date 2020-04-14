package c.service;

import c.common.ConnectionFactory;
import c.model.dao.ManagerDao;
import c.model.dao.MemberDao;
import c.model.vo.Manager;
import c.model.vo.Member;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManagerService {
    private ConnectionFactory factory;

    public ManagerService() {
        factory = ConnectionFactory.getConnection();
    }

    public ArrayList<Manager> selectAllManager(){
        Connection conn = null;
        ArrayList<Manager> list = null;
        try {
            conn = factory.createConnection();
            list = new ManagerDao().selectAllManager(conn);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            factory.close(conn);
        }
        return list;
    }

}
