/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_Connection_Manager.Manager;


import java.sql.*;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Connection_Manager {

private static final SessionFactory sessionFactory = buildSessionFactory();

private static SessionFactory buildSessionFactory() {
    try {
        Configuration configuration = new Configuration();
        configuration.configure();

        StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
        standardServiceRegistryBuilder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = standardServiceRegistryBuilder.build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
    catch(Exception e) {
        throw new ExceptionInInitializerError(e);
    }
}

public static SessionFactory getSessionFactory() {
    return sessionFactory;
}
}