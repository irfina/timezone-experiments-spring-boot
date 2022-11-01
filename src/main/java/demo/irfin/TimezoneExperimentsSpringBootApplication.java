package demo.irfin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/orang")
@Service
@Transactional(readOnly = true)
public class TimezoneExperimentsSpringBootApplication
{
    @Autowired
    private PersonRepository repository;

    public static void main(String[] args)
    {
        SpringApplication.run(TimezoneExperimentsSpringBootApplication.class, args);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> create(@RequestBody OrangCreateDto _dto)
    {
        var entity = new Person();
        entity.setFullname(_dto.fullname);
        entity.setLastActive(_dto.last_active);

        var createdAt = OffsetDateTime.now(ZoneId.of("GMT+5"));
        System.out.println(createdAt);
        entity.setCreatedAt(createdAt);

        repository.save(entity);

        return ResponseEntity.ok("Okeh");
    }

    @GetMapping
    public List<Person> getPeople()
    {
        return repository.findAll();
    }

    static class OrangCreateDto {
        public String fullname;
        public LocalDateTime last_active;
    }
}
