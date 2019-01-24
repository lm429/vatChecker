package matlu.vatChecker;

import matlu.vatChecker.api.CountryListProcessor;
import matlu.vatChecker.api.CountryListService;
import matlu.vatChecker.api.ProcessingResult;
import matlu.vatChecker.json.VatCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CountryListService countryListService;

    @Autowired
    private CountryListProcessor countryListProcessor;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void run(String... args) {
        try {
            go();
        } catch ( AppException e ) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void go() throws AppException {

        List<VatCountry> countryList = countryListService.getCountryList();

        if ( countryList.size() < 3) {
            throw new AppException("Less than 3 countries downloaded?!");
        }

        ProcessingResult result = countryListProcessor.process(countryList);

        System.out.println("3 Countries with lowest VAT:");
        printCountryList( result.getLowestVatCountries() );

        System.out.println("\n3 Countries with highest VAT:");
        printCountryList( result.getHighestVatCountries() );
    }

    private void printCountryList(List<VatCountry> list) {
        for (VatCountry c:list) {
            System.out.println(c.getName() + " " + c.getStandardRate());
        }
    }
}
