
package util.connection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

public class HibernateConnection {

	private static SessionFactory sessionFactory;

    private static final void inicializar() throws Exception
    {      
        try
        {
            Configuration cfg=new Configuration();
            cfg.configure();
            
            new SchemaUpdate(cfg).execute(true,true);
            
            sessionFactory= cfg.buildSessionFactory();
        }
        catch (HibernateException e)
        {
        	e.printStackTrace();
            throw new Exception("Erro ao carregar Hibernate: "+e.getMessage() );
        }
    }
    public static Session getSession() throws Exception
    {
        if (sessionFactory==null)
            inicializar();
        try
        {
            return sessionFactory.openSession();
        }
        catch (HibernateException e)
        {
            throw new Exception("Erro ao criar sessão Hibernate: "+e.getMessage());
        }
    }

}

