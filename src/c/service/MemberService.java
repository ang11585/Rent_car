package c.service;

import c.common.ConnectionFactory;
import c.model.dao.MemberDao;
import c.model.vo.Member;
import myException.CarException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberService {
    private ConnectionFactory factory;

    public MemberService() {
        factory = ConnectionFactory.getConnection();
    }
    public int insertMember(Member member) throws SQLException, CarException {
        Connection conn = factory.createConnection();
        int result = new MemberDao().insertMember(member,conn);
        if (result>0) {
            factory.commit(conn);
        }else{
            factory.rollback(conn);
        }
        ConnectionFactory.close(conn);
        return result;
    }

    public int secession(String userId) {
        Connection conn = null;
        int result = 0;
        try {
            conn = factory.createConnection();
            result = new MemberDao().secession(userId, conn);
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
    public ArrayList<Member> selectAllMember(){
        Connection conn = null;
        ArrayList<Member> list = null;
        try {
            conn = factory.createConnection();
            list = new MemberDao().selectAllMember(conn);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            factory.close(conn);
        }
        return list;
    }


}
