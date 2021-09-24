package in.rays.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.rays.associate.Address;
import in.rays.associate.AuctionItem;
import in.rays.associate.Bid;
import in.rays.associate.Employee;

public class AssociationTest {

	public static void main(String[] args) {

	//	testAssociation();

		testAssociationO2O();
	}

	public static void testAssociationO2O() {

		Employee em = new Employee();
		
		em.setName("Naam");
		
		Address ar = new Address();
		
		ar.setAddress("Pataa");
		
		em.setAddd(ar);
		ar.setEmp(em);
		
		SessionFactory sessio = new Configuration().configure().buildSessionFactory();

		Session ses = sessio.openSession();

		Transaction tr = ses.beginTransaction();

		ses.save(em);

		tr.commit();

		System.out.println("Data  Associated O2O");

		ses.close();

	}

	public static void testAssociation() {

		AuctionItem ait = new AuctionItem();
		ait.setDescription("Crown");

		Bid dib = new Bid();

		dib.setAmount(2000);

		Bid dib1 = new Bid();

		dib1.setAmount(4000);

		Bid dib2 = new Bid();

		dib2.setAmount(6000);

		Set<Bid> bids = new HashSet<Bid>();
		bids.add(dib);
		bids.add(dib1);
		bids.add(dib2);

		ait.setBid(bids);

		AuctionItem ait2 = new AuctionItem();
		ait2.setDescription("Coin");

		Bid dib3 = new Bid();

		dib3.setAmount(3000);

		Bid dib4 = new Bid();

		dib4.setAmount(5000);

		Bid dib5 = new Bid();

		dib5.setAmount(7000);

		Set<Bid> bids1 = new HashSet<Bid>();
		bids1.add(dib3);
		bids1.add(dib4);
		bids1.add(dib5);

		ait2.setBid(bids1);

		AuctionItem ait3 = new AuctionItem();
		ait3.setDescription("Casket");

		Bid dib6 = new Bid();

		dib6.setAmount(1500);

		Bid dib7 = new Bid();

		dib7.setAmount(3500);

		Bid dib8 = new Bid();

		dib8.setAmount(5500);

		Set<Bid> bids2 = new HashSet<Bid>();
		bids2.add(dib6);
		bids2.add(dib7);
		bids2.add(dib8);

		ait3.setBid(bids2);

		SessionFactory sessio = new Configuration().configure().buildSessionFactory();

		Session ses = sessio.openSession();

		Transaction tr = ses.beginTransaction();

		ses.save(ait);
		ses.save(ait2);
		ses.save(ait3);

		tr.commit();

		System.out.println("Data  Associated");

		ses.close();

	}
}
