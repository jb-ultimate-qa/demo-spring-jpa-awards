package my.example.awards.components;

import lombok.AllArgsConstructor;
import my.example.awards.model.License;
import org.hibernate.Session;
import org.hibernate.engine.spi.PersistenceContext;
import org.hibernate.engine.spi.Status;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class HelperService {

    @Transactional(propagation = Propagation.REQUIRED)
    public void printLicenseEntityState2(PersistenceContext context, Session session, License license, String actionDescription) {
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
