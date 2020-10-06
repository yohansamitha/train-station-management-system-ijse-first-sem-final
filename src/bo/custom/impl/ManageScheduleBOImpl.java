package bo.custom.impl;

import bo.custom.ManageScheduleBO;
import dao.DAOFactory;
import dao.custom.*;
import dto.ScheduleDTO;
import entity.schedule;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManageScheduleBOImpl implements ManageScheduleBO {
    ScheduleDAO scheduleDAO = (ScheduleDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ScheduleDAOImpl);
    TrainDAO trainDAO = (TrainDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.TrainDAOImpl);
    Primary_driverDAO primary_driverDAO = (Primary_driverDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.primary_driverDAOImpl);
    Assistant_driverDAO assistant_driverDAO = (Assistant_driverDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.assistant_driverDAOImpl);
    RouteDAO routeDAO = (RouteDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.RouteDAOImpl);

    @Override
    public int getScheduleRowCount() throws SQLException, ClassNotFoundException {
        return scheduleDAO.getRowCount();
    }

    @Override
    public boolean createSchedule(ScheduleDTO scheduleDTO) throws SQLException, ClassNotFoundException {
        System.out.println("bo method in");
        return scheduleDAO.add(new schedule(
                scheduleDTO.getSchedule_ID(),
                scheduleDTO.getEngine_number(),
                scheduleDTO.getPrimary_driver_ID(),
                scheduleDTO.getAssistant_driver_ID(),
                scheduleDTO.getRoute_ID(),
                scheduleDTO.getDate(),
                scheduleDTO.getTime()
        ));
    }

    @Override
    public ArrayList<String> getAllEngineNumbers() throws SQLException, ClassNotFoundException {
        return trainDAO.getAllEngineNumbers();
    }

    @Override
    public ArrayList<String> getAllPrimaryDrivers() throws SQLException, ClassNotFoundException {
        return primary_driverDAO.getAllPrimaryDriverID();
    }

    @Override
    public ArrayList<String> getAllAssistantDrivers() throws SQLException, ClassNotFoundException {
        return assistant_driverDAO.getAllAssistantDriverID();
    }

    @Override
    public ArrayList<String> getAllRoute() throws SQLException, ClassNotFoundException {
        return routeDAO.getAllRouteID();
    }
}
