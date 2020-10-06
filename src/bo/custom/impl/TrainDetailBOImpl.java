package bo.custom.impl;

import bo.custom.TrainDetailBO;
import dao.DAOFactory;
import dao.custom.QueryDAO;
import entity.customEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class TrainDetailBOImpl implements TrainDetailBO {
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.QueryDAOImpl);

    @Override
    public ArrayList<customEntity> getAllTrain(String value) throws SQLException, ClassNotFoundException {
        return queryDAO.getAllTrain(value);
    }
}
