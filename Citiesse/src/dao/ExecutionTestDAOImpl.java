package dao;

import entity.Executiontest;

/**
 *
 * @author 
 */
public class ExecutionTestDAOImpl extends GenericDAOImpl<Executiontest> implements ExecutionTestDAO {

    @Override
    public Class<Executiontest> getEntityClass() {
        return Executiontest.class;
    }
}
