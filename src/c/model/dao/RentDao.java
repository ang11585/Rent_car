package c.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import c.common.ConnectionFactory;
import c.model.vo.Rent;

public class RentDao {
    Properties prop;
    public RentDao() {
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

    public ArrayList<Rent> selectRent(Connection conn) {
        ArrayList<Rent> list = null;
        Statement stmt = null;
        ResultSet rset = null;
        String query = prop.getProperty("selectRent");

        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
            list = new  ArrayList<Rent>();
            while(rset.next()) {
                Rent rent = new Rent();
                rent.setRentNo(rset.getInt("RENT_NO"));
                rent.setCarNo(rset.getInt("CAR_NO"));
                rent.setMemberNo(rset.getInt("MEMBER_NO"));
                rent.setRentStart(rset.getDate("RENT_START"));
                rent.setRentEnd(rset.getDate("RENT_END"));
                rent.setRentCost(rset.getInt("RENT_COST"));
                rent.setInsuranceVariety(rset.getString("INSURANCE_VARIETY"));
                rent.setInsuranceCost(rset.getInt("INSURANCE_COST"));
                list.add(rent);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(stmt);
            ConnectionFactory.close(rset);
        }
        return list;
    }

    public Rent memberSelectRent(String memberId, Connection conn) {
        Rent rent = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = prop.getProperty("memberSelectRent");

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, memberId);
            rset = pstmt.executeQuery();
            rent = new Rent();
            if(rset.next()) {
                rent.setRentNo(rset.getInt("RENT_NO"));
                rent.setCarNo(rset.getInt("CAR_NO"));
                rent.setMemberNo(rset.getInt("MEMBER_NO"));
                rent.setRentStart(rset.getDate("RENT_START"));
                rent.setRentCost(rset.getInt("RENT_COST"));
                rent.setRentEnd(rset.getDate("RENT_END"));
                rent.setInsuranceVariety(rset.getString("INSURANCE_VARIETY"));
                rent.setInsuranceCost(rset.getInt("INSURANCE_COST"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(pstmt);
            ConnectionFactory.close(rset);
        }
        return rent;
    }

    public int insertRent(Rent newRent, Connection conn) {
        int result = 0;
        PreparedStatement pstmt = null;
        String query = prop.getProperty("insertRent");

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, newRent.getCarNo());
            pstmt.setInt(2, newRent.getMemberNo());
            pstmt.setDate(3, newRent.getRentStart());
            pstmt.setDate(4, newRent.getRentEnd());
            pstmt.setInt(5, newRent.getCarNo());
            pstmt.setInt(6, newRent.getMemberNo());
            pstmt.setString(7, newRent.getInsuranceVariety());
            pstmt.setInt(8, newRent.getInsuranceCost());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return result;
    }



}
