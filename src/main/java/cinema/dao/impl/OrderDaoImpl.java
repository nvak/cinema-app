package cinema.dao.impl;

import cinema.dao.OrderDao;
import cinema.exception.DataProcessingException;
import cinema.lib.Dao;
import cinema.model.Order;
import cinema.model.User;
import cinema.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Dao
public class OrderDaoImpl implements OrderDao {
    @Override
    public Order add(Order order) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
            return order;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add order: " + order, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Order> getByUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Order> getOrderHistoryByUser = session.createQuery("SELECT distinct o "
                    + "FROM Order o "
                    + "INNER JOIN FETCH o.tickets t "
                    + "INNER JOIN FETCH t.movieSession ms "
                    + "INNER JOIN FETCH ms.movie m "
                    + "INNER JOIN FETCH ms.cinemaHall mh "
                    + "INNER JOIN FETCH o.user u "
                    + "WHERE u.id = :userId", Order.class);
            getOrderHistoryByUser.setParameter("userId",user.getId());
            return getOrderHistoryByUser.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get order history for user: " + user, e);
        }
    }
}
