package bo;

import bo.custom.impl.LoginBOImpl;
import bo.custom.impl.ManageEmployeeBOImpl;

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
            default:
                return null;
        }
    }

    public enum BoType {
        LoginBOImpl, ManageEmployeeBOImpl
    }
}
