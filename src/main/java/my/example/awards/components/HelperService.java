package my.example.awards.components;

import lombok.AllArgsConstructor;
import my.example.awards.model.Award;
import my.example.awards.model.License;
import org.hibernate.Session;
import org.hibernate.engine.spi.PersistenceContext;
import org.hibernate.engine.spi.Status;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class HelperService {

    // licenses

    @Transactional(propagation = Propagation.REQUIRED)
    public void printLicenseEntityStateRequired(PersistenceContext context, Session session, License license, String actionDescription)
    {
        printLicenseState(context, session, license, actionDescription);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void printLicenseEntityStateRequiresNew(PersistenceContext context, Session session, License license, String actionDescription)
    {
        printLicenseState(context, session, license, actionDescription);
    }

    @Transactional
    public void printLicenseEntityStateDefaultRequired(PersistenceContext context, Session session, License license, String actionDescription)
    {
        printLicenseState(context, session, license, actionDescription);
    }

    private static void printLicenseState(PersistenceContext context, Session session, License license, String actionDescription) {
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

    // awards

    @Transactional(propagation = Propagation.REQUIRED)
    public void printAwardEntityStateRequired(PersistenceContext context, Session session, Award award, String actionDescription) {
        printAwardState(context, session, award, actionDescription);
    }

    @Transactional
    public void printAwardEntityStateDefaultRequired(PersistenceContext context, Session session, Award award, String actionDescription) {
        printAwardState(context, session, award, actionDescription);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void printAwardEntityListRequiresNew(List<Award> awardList) {
        String titles = awardList.stream()
                .map(Award::getTitle)
                .collect(Collectors.joining(", "));
        System.out.println("The List of titles: " + titles);
    }

    private static void printAwardState(PersistenceContext context, Session session, Award award, String actionDescription) {
        int entityCount = session.getStatistics().getEntityCount();
        try {
            Status entityState = context.getEntry(award).getStatus();
            System.out.println("Entity state: " + entityState +
                    "\t\t\t entity id: " + award.getId() + ", " +
                    "\t entity count: " + entityCount +
                    "\t (" + actionDescription + ")"
            );
        }
        catch (Exception e) {
            System.out.println("Entity state: [out of context]\t entity id: " + award.getId() + ", \t entity count: " + entityCount + "\t (" + actionDescription + ")");
        }
    }
}
