package lk.ijse.dep.app.dao.custom.impl;

import lk.ijse.dep.app.dao.custom.OrderDAO;
import lk.ijse.dep.app.entity.Order;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class OrderDetailDAOImpl implements OrderDAO {
    @Override
    public Optional<Order> find(String key) throws Exception {
        return Optional.empty();
    }

    @Override
    public Optional<List<Order>> findAll() throws Exception {
        return Optional.empty();
    }

    @Override
    public void save(Order entity) throws Exception {

    }

    @Override
    public void update(Order entity) throws Exception {

    }

    @Override
    public void delete(String key) throws Exception {

    }

    @Override
    public void setSession(Session session) {

    }

    @Override
    public int count() throws Exception {
        return 0;
    }
}
