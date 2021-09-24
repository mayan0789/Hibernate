package hibernate;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import fiveInherit.Cheque;
import fiveInherit.CreditCard;
import fiveInherit.Payment;

public class HibernateUtil {

	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory != null) {
			return sessionFactory;
		}

		// 1. Set Hibernate properties
		Map<String, Object> settings = new HashMap();
		settings.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/hiberfive");
		settings.put("hibernate.connection.username", "root");
		settings.put("hibernate.connection.password", "root");
		settings.put("hibernate.show_sql", "true");
		settings.put("hibernate.hbm2ddl.auto", "update");
		settings.put(Environment.USE_SECOND_LEVEL_CACHE, true);
		settings.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.jcache.JCacheRegionFactory");
		settings.put("hibernate.javax.cache.provider", "org.ehcache.jsr107.EhcacheCachingProvider");

		StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
		registryBuilder.applySettings(settings);

		registry = registryBuilder.build();

		MetadataSources sources = new MetadataSources(registry);
		//sources.addAnnotatedClass(User2.class);

		sources.addAnnotatedClass(CreditCard.class);
		sources.addAnnotatedClass(Cheque.class);
		
		
		
		Metadata metaData = sources.getMetadataBuilder().build();

		sessionFactory = metaData.getSessionFactoryBuilder().build();
		return sessionFactory;

	}

	public static void shutdown() {

		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

}
