package sistemacompraproveedores;

import org.hibernate.*;
import org.hibernate.boot.registry.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.*;

public class HibernateUtil
{

    private static SessionFactory sessionFactory;

    public HibernateUtil ()
    {
    }

    private static SessionFactory buildSessionFactory ()
    {
            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
    }

    public static SessionFactory getSessionFactory ()
    {
        if (sessionFactory == null)
        {
            sessionFactory = buildSessionFactory();
        } else
        {
            if (sessionFactory.isClosed())
                sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

    public static Session getSession ()
    {
        if (sessionFactory == null || sessionFactory.isClosed())
        {
            sessionFactory = getSessionFactory();
        }
        try
        {
            return sessionFactory.getCurrentSession();
        }
        catch (Exception e)
        {
            return sessionFactory.openSession();
        }
    }

}
