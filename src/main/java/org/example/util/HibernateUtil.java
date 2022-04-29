package org.example.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.joined_table.ClientJoinedTable;
import org.example.model.joined_table.TrainerJoinedTable;
import org.example.model.joined_table.UserJoinedTable;
import org.example.model.mapped_superclass.ClientMappedSuperClass;
import org.example.model.mapped_superclass.TrainerMappedSuperClass;
import org.example.model.mapped_superclass.UserMappedSuperClass;
import org.example.model.single_table.ClientSingleTable;
import org.example.model.single_table.TrainerSingleTable;
import org.example.model.single_table.UserSingleTable;
import org.example.model.table_per_class.ClientTablePerClass;
import org.example.model.table_per_class.TrainerTablePerClass;
import org.example.model.table_per_class.UserTablePerClass;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static final Logger logger = LogManager.getLogger(HibernateUtil.class);

    private static String DEFAULT_HBN_CONFIG_PATH = "src/main/resources/hibernate.cfg.xml";

    public static SessionFactory getSessionFactory() {
        logger.info("start getSessionFactory()");
        File file = new File(DEFAULT_HBN_CONFIG_PATH);
        logger.debug("file name: " + file.getName());
        Configuration configuration = new Configuration().configure(file);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);



          metadataSources.addAnnotatedClass(ClientJoinedTable.class);
          metadataSources.addAnnotatedClass(TrainerJoinedTable.class);
          metadataSources.addAnnotatedClass(UserJoinedTable.class);

          metadataSources.addAnnotatedClass(ClientMappedSuperClass.class);
          metadataSources.addAnnotatedClass(TrainerMappedSuperClass.class);
          metadataSources.addAnnotatedClass(UserMappedSuperClass.class);

          metadataSources.addAnnotatedClass(ClientSingleTable.class);
          metadataSources.addAnnotatedClass(TrainerSingleTable.class);
          metadataSources.addAnnotatedClass(UserSingleTable.class);

          metadataSources.addAnnotatedClass(ClientTablePerClass.class);
          metadataSources.addAnnotatedClass(TrainerTablePerClass.class);
          metadataSources.addAnnotatedClass(UserTablePerClass.class);


        sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        logger.info("end getSessionFactory()");
        return sessionFactory;
    }
}
