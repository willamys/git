package dao;

import entity.Testcase;

/**
 *
 * @author 
 */
public class TestCaseDAOImpl extends GenericDAOImpl<Testcase> implements TestCaseDAO {

    @Override
    public Class<Testcase> getEntityClass() {
        return Testcase.class;
    }
}
