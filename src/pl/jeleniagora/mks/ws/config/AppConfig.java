package pl.jeleniagora.mks.ws.config;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import pl.jelenigora.mks.dao.CompetitionsDao;


@Configuration
@EnableWebMvc
@ComponentScan("pl.jeleniagora.mks.dao, +"
		+ "pl.jeleniagora.mks.types.model")
public class AppConfig /*implements WebMvcConfigurer */{

	@Bean
	public CompetitionsDao competitionsDao() {
		return new CompetitionsDao();
	}
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource out = new DriverManagerDataSource();
		out.setUrl("postgresql://localhost/mks_jg_online");
		out.setDriverClassName("org.postgresql.Driver");
		out.setUsername("mks_jg_online");
		out.setPassword("supertajnehaslo:P");
		return out;
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean out = new LocalContainerEntityManagerFactoryBean();
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		out.setJpaVendorAdapter(vendorAdapter);
		
		out.setPackagesToScan("pl.jeleniagora.types.model");
		out.setDataSource(dataSource());
		
		return out;
		
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
