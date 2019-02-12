package lk.ijse.dep.app.business.custom.impl;

import lk.ijse.dep.app.business.Converter;
import lk.ijse.dep.app.business.custom.ManageItemsBO;
import lk.ijse.dep.app.dao.DAOFactory;
import lk.ijse.dep.app.dao.custom.ItemDAO;
import lk.ijse.dep.app.dto.CustomerDTO;
import lk.ijse.dep.app.dto.ItemDTO;
import lk.ijse.dep.app.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ManageItemsBOImpl implements ManageItemsBO {

    private ItemDAO itemDAO;

    public ManageItemsBOImpl() {
        itemDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    }

    @Override
    public List<ItemDTO> getItems() throws Exception {

        Session mySession = HibernateUtil.getSessionFactory().openSession();
        try(Session session = mySession){
            itemDAO.setSession(session);
            session.beginTransaction();
            List<ItemDTO> customerDTOS = itemDAO.findAll().map(Converter::<ItemDTO>getDTOList).get();
            session.getTransaction().commit();
            return customerDTOS;
        }catch(Exception ex){
            mySession.getTransaction().rollback();
            throw ex;
        }
    }

    @Override
    public void createItem(ItemDTO dto) throws Exception {

        Session mySession = HibernateUtil.getSessionFactory().openSession();
        try(Session session = mySession){
            itemDAO.setSession(session);
            session.beginTransaction();
            itemDAO.save(Converter.getEntity(dto));
            session.getTransaction().commit();
        }catch(Exception ex){
            mySession.getTransaction().rollback();
            throw ex;
        }
    }

    @Override
    public void updateItem(ItemDTO dto) throws Exception {
        Session mySession = HibernateUtil.getSessionFactory().openSession();
        try(Session session = mySession){
            itemDAO.setSession(session);
            session.beginTransaction();
            itemDAO.update(Converter.getEntity(dto));
            session.getTransaction().commit();
        }catch(Exception ex){
            mySession.getTransaction().rollback();
            throw ex;
        }
    }

    @Override
    public void deleteItem(String code) throws Exception {
        Session mySession = HibernateUtil.getSessionFactory().openSession();
        try(Session session = mySession){
            itemDAO.setSession(session);
            session.beginTransaction();
            itemDAO.delete(code);
            session.getTransaction().commit();
        }catch(Exception ex){
            mySession.getTransaction().rollback();
            throw ex;
        }
    }

    @Override
    public ItemDTO findItem(String itemCode) throws Exception {
        Session mySession = HibernateUtil.getSessionFactory().openSession();
        try(Session session = mySession){
            itemDAO.setSession(session);
            session.beginTransaction();
            ItemDTO itemDTO = itemDAO.find(itemCode).map(Converter::<ItemDTO >getDTO).orElse(null);
            session.getTransaction().commit();
            return itemDTO;
        }catch(Exception ex){
            mySession.getTransaction().rollback();
            throw ex;
        }
    }
}

