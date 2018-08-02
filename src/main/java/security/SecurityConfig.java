package security;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("USER")
                .and()
                .withUser("user2").password("qwerty").roles("ADMIN");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
//                .antMatchers("/sample/**")
                .regexMatchers("/*").hasRole("USER")
                .regexMatchers("/jpa.*").hasRole("ADMIN")
                .anyRequest().permitAll()
//                .and()
//                .httpBasic()
                .and()
                .formLogin()
//                .loginPage("/")
//                    .usernameParameter("ziomek")
//                    .passwordParameter("tajemnica")
        ;
    }


    public DataSource dataSource() {
        DriverManagerDataSource dm = new DriverManagerDataSource();
        dm.setDriverClassName("com.mysql.jdbc.Driver");
        dm.setUrl("jdbc:mysql://localhost:3306/academic_department");
        dm.setUsername("root");
        dm.setPassword("coderslab");
        return dm;
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource())
//                .usersByUsernameQuery(
//                        "SELECT login, password, true FROM my_users where login = ?")
//                .authoritiesByUsernameQuery(
//                        "SELECT login, role FROM users_roles WHERE login = ?");
//    }


}
