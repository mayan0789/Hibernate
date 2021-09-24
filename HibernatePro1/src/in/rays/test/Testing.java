package in.rays.test;

import java.util.Iterator;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import in.rays.UserTable;

public class Testing {

	public static void main(String[] args) throws Exception {

		// testAdd();

		// testUpdate();

		// testDelete();

		 testGet();

		// testList();

		// testList2();

		// testCriteria();

		//testCriteria2();
	
		//testProjection();
	
		//testProjection2();
	
       //  testProjection3();
		 
	//UserTable ut = new UserTable();
			//ut = testAuthenticate();
		 
		//	testNamedQuery();
			
	//	testDetachMerge();
	}

	public static void testDetachMerge() {

		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session ses = factory.openSession();

		UserTable user =   (UserTable) ses.get(UserTable.class, 2);
		
		
		ses.close();
		
		
		Session se1 = factory.openSession();
		

		UserTable use1 =   (UserTable) se1.get(UserTable.class, 2);
		
		Transaction tr = se1.beginTransaction();

		user.setName("Mega");
		user.setLastName("Gem");
		
		se1.merge(user);

		tr.commit();
		
		System.out.println("Data  Changed");

		
		
	}

	private static void testNamedQuery() {

		SessionFactory sessio = new Configuration().configure().buildSessionFactory();

		Session ses = sessio.openSession();

		Query q = ses.getNamedQuery("user");

		List li = q.list();

		Iterator it = li.iterator();

		while (it.hasNext()) {
			UserTable ut = (UserTable) it.next();

			System.out.println(ut.getName() + "  " + ut.getLastName());
		}
		
	}

	public static  UserTable testAuthenticate() throws Exception {

		SessionFactory sessio = new Configuration().configure().buildSessionFactory();

		Session ses = sessio.openSession();

		Query q = ses.createQuery("from UserTable where name = ? and lastname =?");
		
		q.setString(0,"Good ");
		q.setString(1,"Boy");
		

		List li = q.list();

		UserTable 	pojo  = null;
		
		if(li.size()==1) {
			
	      pojo	 =  (UserTable) li.get(0);
		
	      System.out.println(pojo.getName()+"   "+ pojo.getLastName()+"    "+pojo.getId());
		
		}else {
			throw new Exception(" You are not a Valid User");
		}
	return pojo;
	}
	

	public static void testProjection3() {

		SessionFactory sessio = new Configuration().configure().buildSessionFactory();

		Session ses = sessio.openSession();

		Criteria crit = ses.createCriteria(UserTable.class);

		crit.add(Restrictions.or(Restrictions.like("name", "dop%"), Restrictions.eq("id", 0)));
		
		List li = crit.list();

		Iterator it = li.iterator();

		while (it.hasNext()) {
		UserTable ut = (UserTable) it.next();

			System.out.println(ut.getId()+"  "+ut.getName());
		}
		
	}

	public static void testProjection2() {

		SessionFactory sessio = new Configuration().configure().buildSessionFactory();

		Session ses = sessio.openSession();

		Criteria crit = ses.createCriteria(UserTable.class);

		ProjectionList pl = Projections.projectionList();
		
		pl.add(Projections.groupProperty("name"));
		
         crit.setProjection(pl);
		
		List li = crit.list();

		Iterator it = li.iterator();

		while (it.hasNext()) {
			Object ut = (Object) it.next();

			System.out.println(ut);
		}
	
		
	}

	public static void testProjection() {

		SessionFactory sessio = new Configuration().configure().buildSessionFactory();

		Session ses = sessio.openSession();

		Criteria crit = ses.createCriteria(UserTable.class);

		ProjectionList pl = Projections.projectionList();
		
		pl.add(Projections.property("id"));
		pl.add(Projections.property("name"));
	
		crit.setProjection(pl);
		
		List li = crit.list();

		Iterator it = li.iterator();

		while (it.hasNext()) {
			Object[] ut = (Object[]) it.next();

			System.out.println(ut[0] + "  " + ut[1]);
		}
	
	}

	public static void testCriteria2() {

		SessionFactory sessio = new Configuration().configure().buildSessionFactory();

		Session ses = sessio.openSession();

		Criteria crit = ses.createCriteria(UserTable.class);

		crit.add(Restrictions.like("name", "do%"));
		crit.add(Restrictions.eq("id", 3));
		
		List<UserTable> list = crit.list();

		Iterator<UserTable> it = list.iterator();

		while (it.hasNext()) {
			UserTable use = (UserTable) it.next();

			System.out.println(use.getName() + "   " + use.getLastName() + "  " + use.getId());
		}

	}

	public static void testCriteria() {

		SessionFactory sessio = new Configuration().configure().buildSessionFactory();

		Session ses = sessio.openSession();

		Criteria crit = ses.createCriteria(UserTable.class);

		List<UserTable> list = crit.list();

		Iterator<UserTable> it = list.iterator();

		while (it.hasNext()) {
			UserTable use = (UserTable) it.next();

			System.out.println(use.getName() + "   " + use.getLastName());
		}

	}

	public static void testList2() {

		SessionFactory sessio = new Configuration().configure().buildSessionFactory();

		Session ses = sessio.openSession();

		Query q = ses.createQuery("Select ust.name, ust.lastName from UserTable ust");

		List li = q.list();

		Iterator it = li.iterator();

		while (it.hasNext()) {
			Object[] ut = (Object[]) it.next();

			System.out.println(ut[0] + "  " + ut[1]);
		}

	}

	public static void testList() {

		SessionFactory sessio = new Configuration().configure().buildSessionFactory();

		Session ses = sessio.openSession();

		Query q = ses.createQuery("from UserTable");

		List li = q.list();

		Iterator it = li.iterator();

		while (it.hasNext()) {
			UserTable ut = (UserTable) it.next();

			System.out.println(ut.getName() + "  " + ut.getLastName());
		}
	}

	public static void testGet() {

		SessionFactory sessio = new Configuration().configure().buildSessionFactory();

		Session ses = sessio.openSession();

		UserTable ut = (UserTable) ses.get(UserTable.class, 1);

		System.out.println("Data  Got");

		System.out.println(ut.getId() + "   " + ut.getName() + "    " + ut.getLastName());
		
		ses.close();
		
		//sessio.close();
		
	//	SessionFactory sessio2 = new Configuration().configure().buildSessionFactory();
		
		Session ses1 = sessio.openSession();
		//UserTable u = (UserTable) ses1.get(UserTable.class, 1);

		System.out.println("Data  Got");

		System.out.println(ut.getId() + "   " + ut.getName() + "    " + ut.getLastName());
		
		ses1.close();

	}

	public static void testDelete() {

		UserTable user = new UserTable();
		user.setId(4);

		SessionFactory sessio = new Configuration().configure().buildSessionFactory();

		Session ses = sessio.openSession();

		Transaction tr = ses.beginTransaction();

		ses.delete(user);

		tr.commit();
		System.out.println("Data  Deleted");

		ses.close();

	}

	public static void testUpdate() {

		UserTable user = new UserTable();
		user.setId(4);
		user.setName("Nope");
		user.setLastName("Boy");

		SessionFactory sessio = new Configuration().configure().buildSessionFactory();

		Session ses = sessio.openSession();

		Transaction tr = ses.beginTransaction();

		ses.update(user);

		tr.commit();
		System.out.println("Data  Changed");

		ses.close();

	}

	public static void testAdd() {

		UserTable user = new UserTable();

		user.setName("Dope");
		user.setLastName("Boy");

		SessionFactory sessio = new Configuration().configure().buildSessionFactory();

		Session ses = sessio.openSession();

		Transaction tr = ses.beginTransaction();

		ses.save(user);

		tr.commit();
		System.out.println("Data  Entered");

		ses.close();

	}
}
