package my.example.awards.components;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
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

    @Transactional
    public void checkEntityStatesFlow() {
        System.out.println("\nTransaction begin");
        System.out.println("~~~~~~~~~~~~~~~~~~~~");

        Session hibernateSession = entityManager.unwrap(Session.class);
        var session = entityManager.unwrap(SessionImplementor.class);
        PersistenceContext context = session.getPersistenceContext();

        // State 1: Transient
        License license = new License("TestLicenseNumber");
        printEntityState(context, hibernateSession, license, "before persist");

        // State 2: Persistent
        entityManager.persist(license);
        printEntityState(context, hibernateSession, license, "after persist");

        // State 3: Detached
        entityManager.detach(license);
        printEntityState(context, hibernateSession, license, "after detach");

        // State 4: Persistent for returned instance (after merge)
        License managedLicence = entityManager.merge(license);
        printEntityState(context, hibernateSession, managedLicence, "after merge");

        // State 4: Removed
        entityManager.remove(managedLicence);
        printEntityState(context, hibernateSession, managedLicence, "after remove");

        // State: Transient
        entityManager.flush();
        printEntityState(context, hibernateSession, managedLicence, "after flush");

        entityManager.clear();
        printEntityState(context, hibernateSession, managedLicence, "after clear");

        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Transaction complete");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void checkTransactionPropagation() {
        Session hibernateSession = entityManager.unwrap(Session.class);
        var session = entityManager.unwrap(SessionImplementor.class);
        PersistenceContext context = session.getPersistenceContext();
        License license = new License("TransactionPropagation_TestLicenseNumber");
        entityManager.persist(license);
        helper.printLicenseEntityStateRequired(context, hibernateSession, license, "after persist");
        helper.printLicenseEntityStateRequiresNew(context, hibernateSession, license, "after persist");
        helper.printLicenseEntityStateDefaultRequired(context, hibernateSession, license, "after persist");
        entityManager.clear();
    }

    @Transactional
    protected void printEntityState(PersistenceContext context, Session session, License license, String actionDescription) {
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
            System.out.println("Entity state: [out of context]\t entity id: " + license.getId() + ", \t entity count: " + entityCount + "\t (" + actionDescription + ")");
        }
    }
}