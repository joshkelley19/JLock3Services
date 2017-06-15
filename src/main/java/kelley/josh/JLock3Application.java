package kelley.josh;

import kelley.josh.model.Entry;
import kelley.josh.model.User;
import kelley.josh.repository.EntryRepository;
import kelley.josh.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JLock3Application {

    @Bean
    InitializingBean saveData(EntryRepository uRepo, UserRepository jRepo) {//method returning an initializing bean
        return () -> {
                jRepo.save(new User("Josh", "Kelley", "jk@yahoo.com", "joshkelley19", "password", 1L));
                uRepo.save(new Entry("Google", "joshkelley19", "cleancode", 1L));
                uRepo.save(new Entry("MySpace", "joshkelley19", "cleancode", 1L));
                uRepo.save(new Entry("Email", "joshkelley19", "cleancode", 1L));
                uRepo.save(new Entry("Facebook", "joshkelley19", "cleancode", 1L));
                uRepo.save(new Entry("Github", "joshkelley19", "cleancode", 1L));
                jRepo.save(new User("Leroy", "Jenkins", "Leroy@aim.com", "LEROY", "JENKINS", 2L));
                uRepo.save(new Entry("Google", "leroy19203", "wowsuchgame", 2L));
                uRepo.save(new Entry("MySpace", "leroy19203", "wowsuchgame", 2L));
                uRepo.save(new Entry("Email", "leroy19203", "wowsuchgame", 2L));
                jRepo.save(new User("YoungMonty", "DeWilmington", "hipsdontlie@gmail.com", "professorx", "tabs2016", 3L));
                uRepo.save(new Entry("Google", "lieutenantdan4eva", "insertpunhere", 3L));
                uRepo.save(new Entry("MySpace", "lieutenantdan4eva", "insertpunhere", 3L));
                uRepo.save(new Entry("Email", "lieutenantdan4eva", "insertpunhere", 3L));

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(JLock3Application.class, args);
    }


}
