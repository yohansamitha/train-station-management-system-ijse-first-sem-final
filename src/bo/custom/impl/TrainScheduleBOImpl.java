package bo.custom.impl;

import bo.custom.TrainScheduleBO;
import dao.DAOFactory;
import dao.custom.QueryDAO;
import entity.customEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class TrainScheduleBOImpl implements TrainScheduleBO {
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.QueryDAOImpl);

    @Override
    public ArrayList<customEntity> getAllSchedule(String value) throws SQLException, ClassNotFoundException {
        return queryDAO.getAllSchedule(value);
    }
}
