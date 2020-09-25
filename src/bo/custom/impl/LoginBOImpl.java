package bo.custom.impl;

import bo.custom.LoginBO;
import dao.DAOFactory;
import dao.custom.UsersDAO;
import dto.UsersDTO;
import entity.Users;

import java.sql.SQLException;

public class LoginBOImpl implements LoginBO {
    UsersDAO usersDAO = (UsersDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.UserDAOImpl);

    @Override
    public UsersDTO getValidated(String userName) throws SQLException, ClassNotFoundException {
        Users validate = usersDAO.validate(userName);
        return new UsersDTO(validate.getUser_name(),validate.getUser_password(),validate.getPosition());
    }
}
