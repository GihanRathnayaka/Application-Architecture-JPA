package lk.ijse.dep.app.dao.custom.impl;

import lk.ijse.dep.app.dao.CrudDAOImpl;
import lk.ijse.dep.app.dao.custom.ItemDAO;
import lk.ijse.dep.app.dao.custom.OrderDAO;
import lk.ijse.dep.app.entity.Customer;
import lk.ijse.dep.app.entity.Order;
import lk.ijse.dep.app.entity.OrderDetail;
import lk.ijse.dep.app.entity.OrderDetailPK;
import org.hibernate.Session;

import java.util.Optional;

public class OrderDAOImpl extends CrudDAOImpl<Order,String>implements OrderDAO{

    private Session session;
    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public int count() throws Exception {
        return (int)session.createQuery("SELECT c FROM Order c ",Order.class ).getFetchSize();
    }
}
