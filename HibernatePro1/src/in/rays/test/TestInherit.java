package in.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.inherit2.Cash2;
import in.co.rays.inherit2.Cheque2;
import in.co.rays.inherit2.CreditCard2;
import in.co.rays.inheritance.Cash;
import in.co.rays.inheritance.Cheque;
import in.co.rays.inheritance.CreditCard;

public class TestInherit {

	public static void main(String[] args) {
		//testInheritTPC();
		
		testInheritTPSC();
	}

	private static void testInheritTPSC() {
		// TODO Auto-generated method stub
		Cheque2 cheq =  new  Cheque2();
		cheq.setAmount(10000);
		cheq.setName("James");
		cheq.setBankName("LML");
		cheq.setCheq_no(0123);
		
		Cash2 cas = new Cash2();
		cas.setAmount(15000);
		cas.setName("John");
		
		CreditCard2 crcad = new CreditCard2();
		
		crcad.setAmount(20000);
		crcad.setCcType("RUPAY");
		crcad.setName("Mikail");
		
		SessionFactory sessio = new Configuration().configure().buildSessionFactory();

		Session ses = sessio.openSession();

		Transaction tr = ses.beginTransaction();

		ses.save(cheq);
		ses.save(cas);
		ses.save(crcad);
		
		tr.commit();
		System.out.println("Data  Entered");

		ses.close();
	}

	private static void testInheritTPC() {
		// TODO Auto-generated method stub
		Cheque cheq =  new  Cheque();
		cheq.setAmount(10000);
		cheq.setName("James");
		cheq.setBankName("LML");
		cheq.setCheq_no(0123);
		
		Cash cas = new Cash();
		cas.setAmount(15000);
		cas.setName("John");
		CreditCard crcad = new CreditCard();
		
		crcad.setAmount(20000);
		crcad.setCcType("RUPAY");
		crcad.setName("Mikail");
		
		SessionFactory sessio = new Configuration().configure().buildSessionFactory();

		Session ses = sessio.openSession();

		Transaction tr = ses.beginTransaction();

		ses.save(cheq);
		ses.save(cas);
		ses.save(crcad);
		
		tr.commit();
		System.out.println("Data  Entered");

		ses.close();
	}
}
