package hibernate;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TEsstINherit {

	public static void main(String[] args) throws Exception {

		// testAdd();

		// testDelete();

		// testUpdate();

		                                    // Criteria one's

		// testGet();

		// testGetbyID();

		// testGetOneCol();

		// testGetMultiCol();
		
	//	testGetCount();
		
		//testNamedQuery();
		
		testNativeQuery();
		
		
				
	}

	public static void testNativeQuery() {
	
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
	
		List<User2> list = session.createNativeQuery("Select * from User2", User2.class).getResultList();
	
		for (User2 user : list) {
		System.out.println(user.getId());
		System.out.println(user.getFirstName());
		}
		
	}

	public static void testNamedQuery() {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query query =	session.getNamedQuery("allUser");
	
		List<User2> list = query.getResultList();
		for (User2 user : list) {
		System.out.println(user.getId());
		System.out.println(user.getFirstName());
		}
	}

	public static void testGetCount() {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
	

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Object []> query = builder.createQuery(Object[].class);

		Root<User2> root = query.from(User2.class);

		query.multiselect(builder.count(root));
		
		Query q = session.createQuery(query);
 
		long count = (long) q.getSingleResult();
 
 
		System.out.println("the count is "  + count);
		

	}

	public static void testGetMultiCol() {
		// TODO Auto-generated method stub
		
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Object []> query = builder.createQuery(Object[].class);

		Root<User2> root = query.from(User2.class);

		query.multiselect(root.get("lastName"), root.get("firstName"));

		Query q = session.createQuery(query);

		List<Object []> user = q.getResultList();
		Iterator<Object []> list = user.iterator();

		while (list.hasNext()) {

			Object [] type = (Object[]) list.next();

			System.out.println(type[0] + "   "+ type[1]);

		}
	}

	public static void testGetOneCol() {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<String> query = builder.createQuery(String.class);

		Root<User2> root = query.from(User2.class);

		query.multiselect(root.get("lastName"));

		Query q = session.createQuery(query);

		List<String> user = q.getResultList();
		Iterator<String> list = user.iterator();

		while (list.hasNext()) {

			String type = list.next();

			System.out.println(type);

		}
	}

	public static void testGetbyID() {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User2> query = builder.createQuery(User2.class);
		Root<User2> root = query.from(User2.class);
		query.select(root).where(builder.equal(root.get("id"), 2));

		Query q = session.createQuery(query);

		List<User2> user = q.getResultList();
		Iterator<User2> list = user.iterator();

		while (list.hasNext()) {

			User2 type = (User2) list.next();

			System.out.println(type.getFirstName() + "   " + type.getLastName() + "  " + type.getUserName());

		}
	}

	public static void testGet() {
		// TODO Auto-generated method stub

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User2> query = builder.createQuery(User2.class);
		Root<User2> root = query.from(User2.class);
		query.select(root);
		Query q = session.createQuery(query);

		List<User2> user = q.getResultList();
		Iterator<User2> list = user.iterator();

		while (list.hasNext()) {

			User2 type = (User2) list.next();

			System.out.println(type.getFirstName() + "   " + type.getLastName() + "  " + type.getUserName());

		}

	
	}

	private static void testUpdate() {
		// TODO Auto-generated method stub

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session sef = factory.openSession();
		Transaction tx = sef.beginTransaction();

		User2 u2 = new User2();

		u2.setId(02);

		u2.setFirstName("pachpan");
		sef.update(u2);

		tx.commit();

		sef.close();

		HibernateUtil.shutdown();
	}

	public static void testDelete() {

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session sef = factory.openSession();
		Transaction tx = sef.beginTransaction();

		User2 u2 = new User2();

		u2.setId(03);

		sef.delete(u2);

		tx.commit();

		sef.close();

		HibernateUtil.shutdown();
	}

	public static void testAdd() throws Exception {

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session sef = factory.openSession();
		Transaction tx = sef.beginTransaction();

		User2 u2 = new User2();

		u2.setFirstName("Bawan");
		u2.setLastName("Trepan");
		u2.setUserName("Ekawan");

		sef.save(u2);
		tx.commit();

		sef.close();

		HibernateUtil.shutdown();

	}

}
