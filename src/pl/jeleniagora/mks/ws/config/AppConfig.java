package pl.jeleniagora.mks.ws.config;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import pl.jeleniagora.mks.dao.aux.MyNamingStrategy;
import pl.jelenigora.mks.dao.CompetitionDataDao;
import pl.jelenigora.mks.dao.CompetitionMappingDao;
import pl.jelenigora.mks.dao.CompetitionsDao;
import pl.jelenigora.mks.dao.CompetitionsDaoInterface;


@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"pl.jeleniagora.mks.dao.repository"})
@ComponentScan("pl.jeleniagora.mks")
public class AppConfig /*implements WebMvcConfigurer */{

	@Bean
	public CompetitionMappingDao competitionMappingDao() {
		return new CompetitionMappingDao();
	}
	
	@Bean
	public CompetitionDataDao competitionDataDao() {
		return new CompetitionDataDao();
	}
	
	@Bean
	public CompetitionsDao competitionsDao() {
		return new CompetitionsDao();
	}

	@Bean
	public MyNamingStrategy myNamingStrategy() {
		return new MyNamingStrategy();
	}

	@Bean
	public DriverManagerDataSource dataSource() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DriverManagerDataSource out = new DriverManagerDataSource();
		out.setUrl("jdbc:postgresql://localhost:5432/mks_jg_online");
		out.setDriverClassName("org.postgresql.Driver");
		out.setUsername("mks_jg_online_user");
		out.setPassword("supertajnehaslo:P");
		return out;
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean out = new LocalContainerEntityManagerFactoryBean();
		
		HashMap<String, String> jpaProperties = new HashMap<String, String>();
		jpaProperties.put("hibernate.physical_naming_strategy", "pl.jeleniagora.mks.dao.aux.MyNamingStrategy");
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		
		out.setJpaVendorAdapter(vendorAdapter);
		out.setJpaPropertyMap(jpaProperties);

		
		out.setPackagesToScan("pl.jeleniagora.mks.types.model");
		out.setDataSource(dataSource());
		
		return out;
		
	}
	
	   @Bean
	   public PlatformTransactionManager transactionManager(
	     EntityManagerFactory emf){
	       JpaTransactionManager transactionManager = new JpaTransactionManager();
	       transactionManager.setEntityManagerFactory(emf);
	 
	       return transactionManager;
	   }
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	    return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		MediaType types[] = {MediaType.TEXT_PLAIN};
		
		StringHttpMessageConverter out = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		out.setSupportedMediaTypes(Arrays.asList(types));
		
		return out; 
	}
}
