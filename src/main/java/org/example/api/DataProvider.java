package org.example.api;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.joined_table.UserJoinedTable;
import org.example.model.mapped_superclass.UserMappedSuperClass;
import org.example.model.single_table.UserSingleTable;
import org.example.model.table_per_class.UserTablePerClass;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import javax.persistence.MappedSuperclass;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class DataProvider<T> implements IDataProvider {

    private static final Logger logger = LogManager.getLogger(DataProvider.class);

    @Override
    public <T> boolean insert(T object) {

        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
            return true;
        } catch (Exception e){
            logger.error(e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return false;
    }

    @Override
    public <T> Optional<T> getById(Class<T> tClass, long id) {
        Transaction transaction = null;
        Optional<T> optional;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            optional = Optional.ofNullable(session.get(tClass, id));
            transaction.commit();
            return optional;
        } catch (Exception e){
            logger.error(e);
            if (transaction != null) {
                transaction.rollback();
            }
            return Optional.empty();
        }
    }

    @Override
    public <T> boolean update(T object) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
            return true;
        } catch (Exception e){
            logger.error(e);
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public <T> boolean delete(T object) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
            return true;
        } catch (Exception e){
            logger.error(e);
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public List<UserTablePerClass> selectAllPerClass() {
        List<UserTablePerClass> list;
        try (Session session = getSession()) {
            list = session.createQuery("from UserTablePerClass ").list();
            return list;
        }
    }

    @Override
    public List<UserSingleTable> selectAllSingleTable() {
        List<UserSingleTable> list;
        try (Session session = getSession()) {
            list = session.createQuery("from UserSingleTable ").list();
            return list;
        }
    }

    @Override
    public List<UserJoinedTable> selectAllJoinedTable() {
        List<UserJoinedTable> list;
        try (Session session = getSession()) {
            list = session.createQuery("from UserJoinedTable ").list();
            return list;
        }
    }

    Session getSession(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        return sessionFactory.openSession();
    }
}
