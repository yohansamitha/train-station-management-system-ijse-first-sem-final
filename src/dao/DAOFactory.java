package dao;

import dao.custom.impl.QueryDAOImpl;
import dao.custom.impl.UsersDAOImpl;

public class DAOFactory {
    static DAOFactory daoFactory;

    public DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public SuperDAO getDAO(DAOType daoType) {
        switch (daoType) {
            case UserDAOImpl:
                return new UsersDAOImpl();
            case QueryDAOImpl:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }

    public enum DAOType {
        UserDAOImpl,QueryDAOImpl
    }
}
