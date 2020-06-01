package com.solvd.dao;

import com.solvd.models.Owner;
import com.solvd.utils.MyBatisConfigUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

public class OwnerDAO implements IOwner{

    private static final Logger LOGGER = Logger.getLogger(OwnerDAO.class);
    private IOwner entityDAO;
    private Class<IOwner> DAOClass = IOwner.class;

    @Override
    public Owner getOwnerById(Long id) {
        SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
        entityDAO = session.getMapper(DAOClass);
        Owner entity =  entityDAO.getOwnerById(id);
        LOGGER.info("session for get owner by id");
        session.close();
        return entity;
    }

    @Override
    public List<Owner> getOwner() {
        SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
        entityDAO = session.getMapper(DAOClass);
        List<Owner> entities =  entityDAO.getOwner();
        session.close();
        return entities;
    }

//    @Override
//    public void insertOwner(Owner entity) {
//        SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
//        entityDAO = session.getMapper(DAOClass);
//        entityDAO.insertOwner(entity);
//        session.commit();
//        session.close();
//    }
//
//    @Override
//    public void deleteOwner(Integer entity) {
//        SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
//        entityDAO = session.getMapper(DAOClass);
//        entityDAO.deleteOwner(entity);
//        session.commit();
//        session.close();
//    }
//
//    public void updateOwner(Owner entity) {
//        SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
//        entityDAO = session.getMapper(DAOClass);
//        entityDAO.updateOwner(entity);
//        session.commit();
//        session.close();
//    }

}