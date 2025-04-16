package my.example.awards.components;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import my.example.awards.model.License;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@AllArgsConstructor
@Service
public class LicenseTransactionalService {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void checkEntityStates() {
        Session hibernateSession = entityManager.unwrap(Session.class);

        // State 1: Transient
        License license = new License("TestLicenseNumber");
        int entityCount = hibernateSession.getStatistics().getEntityCount();
        System.out.println("State: Transient (before persist), entity count: " + entityCount);

        // State 2: Persistent
        entityManager.persist(license);
        entityCount = hibernateSession.getStatistics().getEntityCount();
        System.out.println("State: Persistent (after persist), entity count: " + entityCount);
        System.out.println("Assigned ID (after persist): " + license.getId());

        // State 3: Detached
        entityManager.detach(license);
        entityCount = hibernateSession.getStatistics().getEntityCount();
        System.out.println("State: Detached (after detach), entity count: " + entityCount);

        // State 4: Persistent (after merge)
        License managedLicence = entityManager.merge(license);
        entityCount = hibernateSession.getStatistics().getEntityCount();
        System.out.println("State: Persistent (after merge), entity count: " + entityCount);

        // State 4: Removed
        entityManager.remove(managedLicence);
        entityCount = hibernateSession.getStatistics().getEntityCount();
        System.out.println("State: Removed (after remove), entity count: " + entityCount);

        // State: Detached after transaction (for cleanup)
        entityManager.flush();
        entityCount = hibernateSession.getStatistics().getEntityCount();
        System.out.println("State: ? (after flush), entity count: " + entityCount);

        entityManager.clear();
        entityCount = hibernateSession.getStatistics().getEntityCount();
        System.out.println("State: Detached? (after clear), entity count: " + entityCount);
        System.out.println("Transaction complete");
    }
}