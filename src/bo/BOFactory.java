package bo;

import bo.custom.impl.LoginBOImpl;

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
            default:
                return null;
        }
    }

    public enum BoType {
        LoginBOImpl
    }
}
