package my.example.awards.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class MyPerson {
    private String name;

    @Bean
//    @Scope("singleton")
//    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Scope(scopeName  = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public MyPerson personSingleton() {
        return new MyPerson();
    }

    @Bean
//    @Scope("prototype")
//    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Scope(scopeName  = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public MyPerson personPrototype() {
        return new MyPerson();
    }
}
