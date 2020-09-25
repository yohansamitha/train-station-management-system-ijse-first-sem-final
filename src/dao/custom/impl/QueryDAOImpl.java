package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.QueryDAO;
import entity.customEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<customEntity> getAllEmployee() throws SQLException,ClassNotFoundException {
        String sql="select cashier_ID,first_name,last_name,DOB,address,email_address,reg_date,position from cashier union\n" +
                "select primary_driver_ID,first_name,last_name,DOB,address,email_address,reg_date,position from primary_driver union\n" +
                "select assistant_driver_ID,first_name,last_name,DOB,address,email_address,reg_date,position from assistant_driver";
        ResultSet resultSet = CrudUtil.executeQuery(sql);
        ArrayList<customEntity> customEntities = new ArrayList<>();
        while (resultSet.next()){
            customEntities.add(new customEntity(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getDate(7),
                    resultSet.getString(8)));
        }
        return customEntities;
    }
}
