package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.TrainDAO;
import entity.train;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrainDAOImpl implements TrainDAO {
    @Override
    public boolean add(train train) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO train VALUES(?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,train.getEngine_number(),train.getTrain_name(),train.getEngine_type(),train.getFuel_capacity(),train.getStation_ID());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM train WHERE engine_number=?";
        return false;
    }

    @Override
    public boolean update(train train) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE train SET " +
                "engine_type=?," +
                "fuel_capacity=?," +
                "station_ID=?," +
                "WHERE engine_number=?";
        return false;
    }

    @Override
    public train search(String s) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM train WHERE engine_number=?";
        return null;
    }

    @Override
    public ArrayList<train> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM train";
        ResultSet resultSet = CrudUtil.executeQuery(sql);
        ArrayList<train> trains = new ArrayList<>();
        while (resultSet.next()){
            trains.add(new train(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5)
            ));
        }
        return trains;
    }

    @Override
    public ArrayList<String> getAllEngineNumbers() throws SQLException, ClassNotFoundException {
        String sql = "SELECT engine_number FROM train";
        ResultSet resultSet = CrudUtil.executeQuery(sql);
        ArrayList<String> iDS = new ArrayList<>();
        while (resultSet.next()){
            iDS.add(resultSet.getString(1));
        }
        return iDS;
    }

    @Override
    public int getRowCount() throws SQLException, ClassNotFoundException {
        String sql = "SELECT COUNT(engine_number) FROM train";
        ResultSet resultSet = CrudUtil.executeQuery(sql);
        if (resultSet.next()){
            return resultSet.getInt(1);
        }
        return -1;
    }
}
