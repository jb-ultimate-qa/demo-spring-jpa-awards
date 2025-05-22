package my.example.awards.components;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import my.example.awards.model.Award;
import my.example.awards.model.License;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.Status;
import org.hibernate.engine.spi.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@AllArgsConstructor
@Service
public class LicenseTransactionalService {

    @jakarta.persistence.PersistenceContext
    EntityManager entityManager;
    HelperService helper;

    @Transactional()
    public void checkEntityStatesFlow1() {
        System.out.println("\nTransaction begin");
        System.out.println("~~~~~~~~~~~~~~~~~~~~");

        Session hibernateSession = entityManager.unwrap(Session.class);
        var session = entityManager.unwrap(SessionImplementor.class);
        PersistenceContext context = session.getPersistenceContext();

        // State 1: Transient
        License license = new License("TestLicenseNumber");
        printLicenseEntityState(context, hibernateSession, license, "before persist");

        // State 2: Persistent
        entityManager.persist(license);
        printLicenseEntityState(context, hibernateSession, license, "after persist");

        // State 3: Detached
        entityManager.detach(license);
        printLicenseEntityState(context, hibernateSession, license, "after detach");

        // State 4: Persistent for returned instance (after merge)
        License managedLicence = entityManager.merge(license);
        printLicenseEntityState(context, hibernateSession, managedLicence, "after merge");

        // State 4: Removed
        entityManager.remove(managedLicence);
        printLicenseEntityState(context, hibernateSession, managedLicence, "after remove");

        // State: Transient
        entityManager.flush();
        printLicenseEntityState(context, hibernateSession, managedLicence, "after flush");

        entityManager.clear();
        printLicenseEntityState(context, hibernateSession, managedLicence, "after clear");

        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Transaction complete");
    }

    @Transactional()
    public void checkEntityStatesFlow2() {
        System.out.println("\nTransaction begin");
        System.out.println("~~~~~~~~~~~~~~~~~~~~");

        Session hibernateSession = entityManager.unwrap(Session.class);
        var session = entityManager.unwrap(SessionImplementor.class);
        PersistenceContext context = session.getPersistenceContext();

        Award awardEntity = new Award(123, (short)2002, "TestAward");
        entityManager.persist(awardEntity);
        entityManager.detach(awardEntity);
        Award managedAwardEntity = entityManager.merge(awardEntity);
        entityManager.remove(managedAwardEntity);
        entityManager.clear();

        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Transaction complete");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void checkEntityStatesFlow() {
        Session hibernateSession = entityManager.unwrap(Session.class);
        var session = entityManager.unwrap(SessionImplementor.class);
        PersistenceContext context = session.getPersistenceContext();
        License license = new License("TestLicenseNumber");
        entityManager.persist(license);
        helper.printLicenseEntityState2(context, hibernateSession, license, "after persist");
        entityManager.clear();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected void printLicenseEntityState(PersistenceContext context, Session session, License license, String actionDescription) {
        int entityCount = session.getStatistics().getEntityCount();
        try {
            Status entityState = context.getEntry(license).getStatus();
            System.out.println("Entity state: " + entityState +
                    "\t\t\t entity id: " + license.getId() + ", " +
                    "\t entity count: " + entityCount +
                    "\t (" + actionDescription + ")"
            );
        }
        catch (Exception e) {
            System.out.println("Entity state: [out of context]" +
                    "\t entity id: " + license.getId() + ", " +
                    "\t entity count: " + entityCount +
                    "\t (" + actionDescription + ")"
            );
        }
    }
}