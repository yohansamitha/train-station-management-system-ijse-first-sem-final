package bo;

import bo.custom.impl.*;

public class BOFactory {
    static BOFactory boFactory;

    public BOFactory() {
    }

    public static BOFactory getInstance() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public SuperBO getBO(BoType boType) {
        switch (boType) {
            case LoginBOImpl:
                return new LoginBOImpl();
            case ManageEmployeeBOImpl:
                return new ManageEmployeeBOImpl();
            case FindTripBOImpl:
                return new FindTripBOImpl();
            case ManageScheduleBOImpl:
                return new ManageScheduleBOImpl();
            case ManageCustomerBOImpl:
                return new ManageCustomerBOImpl();
            case TrainDetailBOImpl:
                return new TrainDetailBOImpl();
            case TrainScheduleBOImpl:
                return new TrainScheduleBOImpl();
            case ManageTrainBOImpl:
                return new ManageTrainBOImpl();
            case ManageRouteBOImpl:
                return new ManageRouteBOImpl();
            default:
                return null;
        }
    }

    public enum BoType {
        LoginBOImpl,
        ManageEmployeeBOImpl,
        FindTripBOImpl,
        ManageScheduleBOImpl,
        ManageCustomerBOImpl,
        TrainDetailBOImpl,
        TrainScheduleBOImpl,
        ManageTrainBOImpl,
        ManageRouteBOImpl,
    }
}
