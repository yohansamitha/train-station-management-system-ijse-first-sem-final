package bo.custom.impl;

import bo.custom.LoginBO;
import dao.DAOFactory;
import dao.custom.UsersDAO;

import java.sql.SQLException;

public class LoginBOImpl implements LoginBO {
    UsersDAO usersDAO = (UsersDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.UserDAOImpl);
    @Override
    public boolean getValidated(String userName, String password) throws SQLException, ClassNotFoundException {
        return usersDAO.validate(userName, password);
    }
}
