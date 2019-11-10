package ufsc.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HotelApplication {
    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(HotelApplication.class, args);
    }

    public static Object getBean(Class<?> clazz) {
        return applicationContext.getBean(clazz);
    }
}
