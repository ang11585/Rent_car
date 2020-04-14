package c.model.dao;

import c.common.ConnectionFactory;
import c.model.vo.Manager;
import c.model.vo.Member;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class ManagerDao {
    private Properties prop;

    public ManagerDao() {
        prop = new Properties();
        try {
            prop.load(new FileReader("resources/query.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Manager> selectAllManager(Connection conn) {
        ArrayList<Manager> list = null;
        Statement stmt = null;
        ResultSet rset = null;
        String query = prop.getProperty("selectAllManager");

        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
            list = new ArrayList<Manager>();
            while(rset.next()) {
                Manager manager = new Manager();
                manager.setManagerNo(rset.getInt("manager_no"));
                manager.setManagerId(rset.getString("manager_id"));
                manager.setManagerPwd(rset.getString("manager_pwd"));
                list.add(manager);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(rset);
            ConnectionFactory.close(stmt);
        }
        return list;
    }
}
