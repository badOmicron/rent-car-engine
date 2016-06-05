package mx.bhit.omicron.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ImportResource({ "classpath*:/enviromentContext.xml", "classpath*:/daoContext.xml" })
class AppConfig {

	/**
	 * TODO [Agregar documentacion al método]
	 * 
	 * @author @author Orlando Adrián Ramos Galván (orlando.ramos@ine.mx,
	 *         orlandoa.ramos@outlook.com)
	 */
	public AppConfig() {
		// TODO [codificar el cuerpo del método]

	}

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/userbase");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("root");
		return driverManagerDataSource;
	}

}
