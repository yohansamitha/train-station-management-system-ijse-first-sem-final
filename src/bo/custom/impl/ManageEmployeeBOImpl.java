package bo.custom.impl;

import bo.custom.ManageEmployeeBO;
import dao.DAOFactory;
import dao.custom.Assistant_driverDAO;
import dao.custom.CashierDAO;
import dao.custom.Primary_driverDAO;
import dao.custom.QueryDAO;
import dto.AssistantDriverDTO;
import dto.primary_driverDTO;
import entity.assistant_driver;
import entity.customEntity;
import entity.primary_driver;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManageEmployeeBOImpl implements ManageEmployeeBO {
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.QueryDAOImpl);
    Primary_driverDAO primary_driverDAO = (Primary_driverDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.primary_driverDAOImpl);
    Assistant_driverDAO assistant_driverDAO = (Assistant_driverDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.assistant_driverDAOImpl);
    CashierDAO cashierDAO = (CashierDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.CashierDAOImpl);
    @Override
    public ArrayList<customEntity> getAllEmployee() throws SQLException, ClassNotFoundException {
        return queryDAO.getAllEmployee();
    }

    @Override
    public boolean addPrimaryDriver(primary_driverDTO primary_driver) throws SQLException, ClassNotFoundException {
        return primary_driverDAO.add(new primary_driver(
                primary_driver.getPrimary_driver_ID(),
                primary_driver.getFirst_name(),
                primary_driver.getLast_name(),
                primary_driver.getDOB(),
                primary_driver.getAddress(),
                primary_driver.getEmail_address(),
                primary_driver.getReg_date(),
                primary_driver.getPosition()
        ));
//        return false;
    }

    @Override
    public boolean addAssistantDriver(AssistantDriverDTO assistantDriverDTO) throws SQLException, ClassNotFoundException {
        return assistant_driverDAO.add(new assistant_driver(
                 assistantDriverDTO.getAssistant_driver_ID(),
                assistantDriverDTO.getFirst_name(),
                assistantDriverDTO.getLast_name(),
                assistantDriverDTO.getDOB(),
                assistantDriverDTO.getAddress(),
                assistantDriverDTO.getEmail_address(),
                assistantDriverDTO.getReg_date(),
                assistantDriverDTO.getPosition()
                ));
    }

    @Override
    public int getCashierRowCount() throws SQLException, ClassNotFoundException {
        return cashierDAO.getRowCount();
//        return 0;
    }

    @Override
    public int getAssistantDriverRowCount() throws SQLException, ClassNotFoundException {
        return assistant_driverDAO.getRowCount();
    }

    @Override
    public int getPrimaryDriverRowCount() throws SQLException, ClassNotFoundException {
        return primary_driverDAO.getRowCount();
    }


}
