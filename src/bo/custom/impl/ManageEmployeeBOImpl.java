package bo.custom.impl;

import bo.custom.ManageEmployeeBO;
import dao.DAOFactory;
import dao.custom.*;
import db.DBConnection;
import dto.AssistantDriverDTO;
import dto.UsersDTO;
import dto.cashierDTO;
import dto.primary_driverDTO;
import entity.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageEmployeeBOImpl implements ManageEmployeeBO {
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.QueryDAOImpl);
    Primary_driverDAO primary_driverDAO = (Primary_driverDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.primary_driverDAOImpl);
    Assistant_driverDAO assistant_driverDAO = (Assistant_driverDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.assistant_driverDAOImpl);
    CashierDAO cashierDAO = (CashierDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.CashierDAOImpl);
    UsersDAO usersDAO = (UsersDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.UserDAOImpl);

    @Override
    public ArrayList<customEntity> getAllEmployee() throws SQLException, ClassNotFoundException {
        return queryDAO.getAllEmployee();
    }

    @Override
    public boolean addCashier(cashierDTO cashierDTO, UsersDTO cashier) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            boolean addUser = usersDAO.add(new Users(cashier.getUserName(), cashier.getUserPassword(), cashier.getPosition()));
            System.out.println(addUser + " add user");
            int userID = usersDAO.getRowCount();
            System.out.println(userID + " userID");
            if (addUser) {
                boolean cashierAdd = cashierDAO.add(new cashier(
                        cashierDTO.getCashier_ID(),
                        usersDAO.getRowCount(),
                        cashierDTO.getFirst_name(),
                        cashierDTO.getLast_name(),
                        cashierDTO.getDOB(),
                        cashierDTO.getAddress(),
                        cashierDTO.getEmail_address(),
                        cashierDTO.getReg_date(),
                        cashierDTO.getPosition()));
                if (cashierAdd) {
                    connection.commit();
                    System.out.println("connection true");
                    return true;
                }
            } else {
                connection.rollback();
            }
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
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
    public int getUserRowCount() throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public int getAssistantDriverRowCount() throws SQLException, ClassNotFoundException {
        return assistant_driverDAO.getRowCount();
    }

    @Override
    public int getPrimaryDriverRowCount() throws SQLException, ClassNotFoundException {
        return primary_driverDAO.getRowCount();
    }

    @Override
    public boolean updatePrimaryDriver(primary_driverDTO primary_driverDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateAssistantDriver(AssistantDriverDTO assistantDriverDTO) throws SQLException, ClassNotFoundException {
        return false;
    }


}
