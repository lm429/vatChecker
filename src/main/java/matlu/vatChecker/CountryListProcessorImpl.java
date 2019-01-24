package matlu.vatChecker;

import matlu.vatChecker.api.CountryListProcessor;
import matlu.vatChecker.api.ProcessingResult;
import matlu.vatChecker.json.VatCountry;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountryListProcessorImpl implements CountryListProcessor  {

    public ProcessingResult process(List<VatCountry> countryList) {

        countryList.sort( (c1,c2) -> Double.compare(c1.getStandardRate(), c2.getStandardRate()) );

        ProcessingResult result = new ProcessingResult();

        List<VatCountry> lowest = new ArrayList<>();
        List<VatCountry> highest = new ArrayList<>();

        for (int i=0; i<3; i++) {
            lowest.add(countryList.get(i));
            highest.add(countryList.get(countryList.size()-i-1));
        }

        result.setLowestVatCountries( lowest );
        result.setHighestVatCountries( highest );

        return result;
    }
}
