package dao;

import entity.Testcasesetup;

/**
 *
 * @author 
 */
public class TestCaseSetupDAOImpl extends GenericDAOImpl<Testcasesetup> implements TestCaseSetupDAO {

    @Override
    public Class<Testcasesetup> getEntityClass() {
        return Testcasesetup.class;
    }
}
