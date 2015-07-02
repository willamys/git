package dao;

import entity.Result;

/**
 *
 * @author 
 */
public class ResultDAOImpl extends GenericDAOImpl<Result> implements ResultDAO {

  
    public Class<Result> getEntityClass() {
        return Result.class;
    }
}
