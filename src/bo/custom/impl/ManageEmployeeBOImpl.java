package bo.custom.impl;

import bo.custom.ManageEmployeeBO;
import dao.DAOFactory;
import dao.custom.QueryDAO;
import entity.customEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManageEmployeeBOImpl implements ManageEmployeeBO {
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.QueryDAOImpl);
    @Override
    public ArrayList<customEntity> getAllEmployee() throws SQLException, ClassNotFoundException {
        return queryDAO.getAllEmployee();
    }
}
