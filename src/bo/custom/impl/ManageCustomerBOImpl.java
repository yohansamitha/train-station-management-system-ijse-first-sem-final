package bo.custom.impl;

import bo.custom.ManageCustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManageCustomerBOImpl implements ManageCustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.CustomerDAOImpl);

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<customer> all = customerDAO.getAll();
        ArrayList<CustomerDTO> allCustomer = new ArrayList<>();
        for (customer cus : all) {
            allCustomer.add(new CustomerDTO(
                    cus.getCustomer_ID(),
                    cus.getFirst_name(),
                    cus.getLast_name(),
                    cus.getDOB(),
                    cus.getAddress(),
                    cus.getEmail_address()
            ));
        }
        return allCustomer;
    }

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.add(new customer(
                customerDTO.getCustomer_ID(),
                customerDTO.getFirst_name(),
                customerDTO.getLast_name(),
                customerDTO.getDOB(),
                customerDTO.getAddress(),
                customerDTO.getEmail_address()
        ));
    }

    @Override
    public String getNewCustomerID() throws SQLException, ClassNotFoundException {
        int customerRowCount = customerDAO.getRowCount();
        if (customerRowCount < 9) {
            return ("C00" + (customerRowCount + 1));
        } else if (customerRowCount < 99) {
            return ("C0" + (customerRowCount + 1));
        } else {
            return ("C" + (customerRowCount + 1));
        }

    }

    @Override
    public ArrayList<CustomerDTO> CustomerSearch(String customer) throws SQLException, ClassNotFoundException {
        ArrayList<entity.customer> allCustomers = customerDAO.liveSearch(customer);
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        for (entity.customer customer1: allCustomers) {
            customerDTOS.add(new CustomerDTO(
                    customer1.getCustomer_ID(),
                    customer1.getFirst_name(),
                    customer1.getLast_name(),
                    customer1.getDOB(),
                    customer1.getAddress(),
                    customer1.getEmail_address()
            ));
        }
        return customerDTOS;
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

}
