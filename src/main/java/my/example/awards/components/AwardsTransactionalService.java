package my.example.awards.components;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import my.example.awards.model.Award;
import org.hibernate.Session;
import org.hibernate.engine.spi.PersistenceContext;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Transactional
@AllArgsConstructor
@Service
public class AwardsTransactionalService {

    @jakarta.persistence.PersistenceContext
    EntityManager entityManager;
    HelperService helper;

    public void checkAwardEntityStatesFlow() {
        System.out.println("\nTransaction begin");
        System.out.println("~~~~~~~~~~~~~~~~~~~~");

        Session hibernateSession = entityManager.unwrap(Session.class);
        var session = entityManager.unwrap(SessionImplementor.class);
        PersistenceContext context = session.getPersistenceContext();

        List<Award> awardList = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            Award award = new Award(100 + i, (short) (2000 + 1), "TestAward-" + i);
            entityManager.persist(award);
            awardList.add(award);
            helper.printAwardEntityStateRequired(context, hibernateSession, award, "after persist");
        }
        helper.printAwardEntityListRequiresNew(awardList);

        Award entityToDetach = entityManager.find(Award.class, 102);
        entityManager.detach(entityToDetach);
        helper.printAwardEntityStateDefaultRequired(context, hibernateSession, entityToDetach, "after detach");

        Award entityToRemove = entityManager.find(Award.class, 104);
        entityManager.remove(entityToRemove);

        entityManager.clear();

        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Transaction complete");
    }

}