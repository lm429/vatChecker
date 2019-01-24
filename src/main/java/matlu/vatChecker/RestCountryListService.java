package matlu.vatChecker;

import matlu.vatChecker.api.CountryListService;
import matlu.vatChecker.json.VatCountry;
import matlu.vatChecker.json.VatCountryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestCountryListService implements CountryListService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<VatCountry> getCountryList() throws AppException {

        try {
            VatCountryList vatCountryList = restTemplate.getForObject("http://jsonvat.com/", VatCountryList.class);
            List<VatCountry> countryList = vatCountryList.getRates();
            for (VatCountry c:countryList) {
                c.findStandardRate();;
            }
            return countryList;
        } catch ( RestClientException e ) {
            throw  new AppException(e.getMessage());
        }
    }
}
