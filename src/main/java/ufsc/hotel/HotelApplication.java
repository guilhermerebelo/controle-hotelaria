package ufsc.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ufsc.hotel.gerador.GeradorDados;

@SpringBootApplication
public class HotelApplication {
    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(HotelApplication.class, args);
        applicationContext.getBean(GeradorDados.class).gerar();
    }

    public static Object getBean(Class<?> clazz) {
        return applicationContext.getBean(clazz);
    }
}
