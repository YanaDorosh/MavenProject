package com.solvd.dao;

import com.solvd.models.Ships;
import com.solvd.utils.MyBatisConfigUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ShipsDAO implements IShips {

    private IShips entityDAO;
    private Class<IShips> DAOClass = IShips.class;

    @Override
    public Ships getShipsId(Integer id) {
        SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
        entityDAO = session.getMapper(DAOClass);
        Ships entity = entityDAO.getShipsId(id);
        session.close();
        return entity;

    }

    @Override
    public List<Ships> getShips() {
        SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
        entityDAO = session.getMapper(DAOClass);
        List<Ships> entities = entityDAO.getShips();
        session.close();
        return entities;

    }

    @Override
    public void insertShips(Ships entity) {
        SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
        entityDAO = session.getMapper(DAOClass);
        entityDAO.insertShips(entity);
        session.commit();
        session.close();
    }

    @Override
    public void deleteShips(Ships entity) {
        SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
        entityDAO = session.getMapper(DAOClass);
        entityDAO.deleteShips(entity);
        session.commit();
        session.close();
    }

    @Override
    public void updateShips(Ships entity) {
        SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
        entityDAO = session.getMapper(DAOClass);
        entityDAO.updateShips(entity);
        session.commit();
        session.close();
    }

}



