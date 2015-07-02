package dao;

import entity.User;

/**
 *
 * @author 
 */
public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO {

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}
