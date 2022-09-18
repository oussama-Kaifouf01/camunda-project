package com.example.workflow.Repo;

import com.example.workflow.JDBC.JDBCHelper;
import com.example.workflow.Modals.User;
import org.camunda.bpm.engine.rest.exception.RestException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepoJDBC {



    public static final String INSERT_USER_SQL_QUERY = "INSERT INTO USERS(id,name,age,adult,video_game) VALUES(?,?,?,?,?)";
    public static final String SELECT_LATEST_ID = "SELECT COUNT(*) AS total FROM users";
    public static final String UPDATE_VIDEO_GAME_SQL_QUERY = "UPDATE PERSON SET video_game=? WHERE id=?";


    public static void insertUser(User user) throws SQLException
    {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCHelper.getConnection();
            if (con == null) {
                //TODO:LOGGER
                System.out.println("Error getting the connection. Please check if the DB server is running");
                return;
            }
            con.setAutoCommit(false);
            ps = con.prepareStatement(INSERT_USER_SQL_QUERY);
            ps.setLong(1, user.getId());
            ps.setString(2, user.getName());
            ps.setLong(3, user.getAge());
            ps.setBoolean(4, user.isAdult());
            ps.setString(5, user.getVideoGame());
            ps.execute();
            con.commit();
        } catch (SQLException e) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException e1) {
                throw e1;
            }
            throw e;
        } finally {
            try {
                JDBCHelper.closePrepaerdStatement(ps);
                JDBCHelper.closeConnection(con);
            } catch (SQLException e) {
                throw e;
            }
        }
        //
    }

    public static void updateVideoGame(int id,String videoGame) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCHelper.getConnection();
            if (con == null) {
                //TODO:LOGGER
                System.out.println("Error getting the connection. Please check if the DB server is running");
                return;
            }
            con.setAutoCommit(false);
            ps = con.prepareStatement(UPDATE_VIDEO_GAME_SQL_QUERY);
            ps.setLong(1, id);
            ps.setString(2, videoGame);
            ps.execute();
            con.commit();
        } catch (SQLException e) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException e1) {
                throw e1;
            }
            throw e;
        } finally {
            try {
                JDBCHelper.closePrepaerdStatement(ps);
                JDBCHelper.closeConnection(con);
            } catch (SQLException e) {
                throw e;
            }
        }
    }


}
