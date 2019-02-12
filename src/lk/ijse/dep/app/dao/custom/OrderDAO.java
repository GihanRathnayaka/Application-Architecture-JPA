package lk.ijse.dep.app.dao.custom;

import lk.ijse.dep.app.dao.CrudDAO;
import lk.ijse.dep.app.entity.Order;
import org.hibernate.Session;

public interface OrderDAO extends CrudDAO<Order, String> {

    int count() throws Exception;

}
