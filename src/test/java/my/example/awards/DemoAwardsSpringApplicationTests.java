package my.example.awards;

import my.example.awards.beans.MyPerson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
class DemoAwardsSpringApplicationTests {

    private static final String NAME = "John Smith";
    private static final String NAME_OTHER = "Anna Jones";

    @Test
    public void givenSingletonScope_whenSetName_thenEqualNames() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("scopes.xml");

        MyPerson personSingletonA = (MyPerson) applicationContext.getBean("personSingleton");
        MyPerson personSingletonB = (MyPerson) applicationContext.getBean("personSingleton");

        personSingletonA.setName(NAME);
        Assertions.assertEquals(NAME, personSingletonB.getName());

        ((AbstractApplicationContext) applicationContext).close();
    }

    @Test
    public void givenPrototypeScope_whenSetNames_thenDifferentNames() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("scopes.xml");

        MyPerson personPrototypeA = (MyPerson) applicationContext.getBean("personPrototype");
        MyPerson personPrototypeB = (MyPerson) applicationContext.getBean("personPrototype");

        personPrototypeA.setName(NAME);
        personPrototypeB.setName(NAME_OTHER);

        Assertions.assertEquals(NAME, personPrototypeA.getName());
        Assertions.assertEquals(NAME_OTHER, personPrototypeB.getName());

        ((AbstractApplicationContext) applicationContext).close();
    }



    @Test
    void contextLoads() {
    }

}
