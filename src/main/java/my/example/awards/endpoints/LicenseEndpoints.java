package my.example.awards.endpoints;

import lombok.AllArgsConstructor;
import my.example.awards.components.LicenseTransactionalService;
import my.example.awards.endpoints.helper.QueryResultPrettier;
import my.example.awards.model.License;
import my.example.awards.repo.LicenseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static my.example.awards.endpoints.helper.HtmlHelper.generateHtmlLinks;

@AllArgsConstructor
@RestController
@RequestMapping("/license")
public class LicenseEndpoints {
    private final LicenseRepository licenseRepository;
    private final LicenseTransactionalService licenseService;

    @GetMapping(value = "/", produces = "text/html")
    String getLinks(){
        return generateHtmlLinks("license", "all", "transactions");
    }

    @GetMapping(value = "all", produces = "text/plain")
    String getAll(){
        List<License> resultList = licenseRepository.findAll();
        return QueryResultPrettier.concatenateObjects(resultList);
    }

    @GetMapping(value = "transactions", produces = "text/plain")
    void testTransactions(){
        licenseService.checkEntityStatesFlow();
    }

}
