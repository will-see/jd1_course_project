package services.impl;

import DAO.RoleDao;
import DAO.impl.RoleDaoImpl;
import services.RoleService;
import services.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class RoleServiceImpl extends AbstractService implements RoleService {
    private static volatile RoleService INSTANCE = null;
    private RoleDao authorDao = RoleDaoImpl.getInstance();



    public static RoleService getInstance() {
        RoleService RoleService = INSTANCE;
        if (RoleService == null) {
            synchronized (RoleServiceImpl.class) {
                RoleService = INSTANCE;
                if (RoleService == null) {
                    INSTANCE = RoleService = new RoleServiceImpl();
                }
            }
        }

        return RoleService;
    }
}
