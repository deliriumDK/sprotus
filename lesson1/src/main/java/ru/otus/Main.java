package ru.otus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.service.StudentTestingService;

import java.util.Locale;

@ComponentScan
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        StudentTestingService service = context.getBean(StudentTestingService.class);
        service.startStudentTesting();
    }

    @Bean
    public  static PropertySourcesPlaceholderConfigurer propertySourceConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    @Bean
    public Locale locale(@Value("${locale.prop}") String locale) {
        return new Locale(locale);
    }
}