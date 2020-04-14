package c.model.dao;

import c.common.ConnectionFactory;
import c.model.vo.Member;
import myException.CarException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class MemberDao {
    private Properties prop;

    public MemberDao() {
        prop = new Properties();
        try {
            prop.load(new FileReader("resources/query.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int insertMember(Member member, Connection conn) throws CarException {
        int result = 0;
        Statement stmt = null;

        String query = prop.getProperty("insertMember");


        try {
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, member.getMemberId());
            pstmt.setString(2, member.getMemberPwd());
            pstmt.setString(3, member.getMemberName());
            pstmt.setDate(4, member.getMemberBirth());
            pstmt.setString(5, member.getMemberPhone());
            pstmt.setString(6, member.getMemberEmail());
            pstmt.setString(7, member.getMemberLicenseType());
            pstmt.setString(8, member.getMemberLicenseNo());
            pstmt.setDate(9, member.getMemberTestExp());
            pstmt.setString(10, member.getMemberAddress());
            result = pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new CarException(
                    "insertMember() 메소드 처리 불가" + e.getMessage());
        } finally {
            ConnectionFactory.close(stmt);
        }
        return result;

    }

    public int secession(String userId, Connection conn) {
        int result = 0;
        PreparedStatement pstmt = null;
        String query = "DELETE FROM MEMBER WHERE MEMBER_ID = ?";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, userId);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(pstmt);
        }

        return result;
    }
    public ArrayList<Member> selectAllMember(Connection conn) {
        ArrayList<Member> list = null;
        Statement stmt = null;
        ResultSet rset = null;
        String query = prop.getProperty("selectAllMember");

        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
            list = new ArrayList<Member>();
            while(rset.next()) {
                Member member = new Member();
                member.setMemberNo(rset.getInt("MEMBER_NO"));
                member.setMemberId(rset.getString("MEMBER_ID"));
                member.setMemberPwd(rset.getString("MEMBER_PWD"));
                member.setMemberName(rset.getString("MEMBER_NAME"));
                member.setMemberBirth(rset.getDate("MEMBER_BIRTH"));
                member.setMemberPhone(rset.getString("MEMBER_PHONE"));
                member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
                member.setMemberLicenseType(rset.getString("MEMBER_LICENSE_TYPE"));
                member.setMemberLicenseNo(rset.getString("MEMBER_LICENSE_NO"));
                member.setMemberTestExp(rset.getDate("MEMBER_TEST_EXP"));
                member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
                list.add(member);
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
