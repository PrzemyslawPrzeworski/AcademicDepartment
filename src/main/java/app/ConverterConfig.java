package app;

import converter.CourseConverter;
import converter.DegreeConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
@ComponentScan (basePackages = "controller")
@EnableTransactionManagement
public class ConverterConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        super.addFormatters(registry);
        registry.addConverter(courseConverter());
        registry.addConverter(degreeConverter());
    }

    @Bean
    CourseConverter courseConverter() {
        return new CourseConverter();
    }

    @Bean
    DegreeConverter degreeConverter() {
        return new DegreeConverter();
    }



}
