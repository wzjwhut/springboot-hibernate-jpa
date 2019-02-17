package example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
@ControllerAdvice
public class Example  implements ApplicationRunner{
    private final static Logger log = LogManager.getLogger(Example.class);

    @Autowired
    private PersonRepository personRepository;


    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        log.info("main");
        SpringApplication.run(Example.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("============= springboot started ==============");
        {
            Person person = new Person();
            person.setId(1);
            person.setEmailAddress("wzj_whut@163.com");
            person.setFirstname("wzj");
            person.setLastname("whut");
            personRepository.save(person);
        }

        {
            Person p = personRepository.findByIdWithQuery(1);
            log.info("findByIdWithQuery {}", p);
        }

        {
            personRepository.updateWithQuery(1, "new_name");
        }

    }

}
