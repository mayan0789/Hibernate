package fiveInherit;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.HibernateUtil;

public class TestInherit {

	public static void main(String[] args) {
		
		CreditCard cc = new CreditCard();
		cc.setAmount(10000);
		cc.setCcTye("VISA");
		
		Cheque cheque = new Cheque();
		cheque.setAmount(5600);
		cheque.setCheqNo(45612);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		
			session.save(cc);
			session.save(cheque);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
		} finally {
			session.close();
			HibernateUtil.shutdown();
		}
	}
	}

