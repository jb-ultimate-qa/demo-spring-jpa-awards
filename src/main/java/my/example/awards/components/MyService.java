package my.example.awards.components;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MyService {

    private final MyComponent component;

    public void testComponent(){
        System.out.print("Hello from MyService and ... ");
        component.demoFunction();
    }
}
