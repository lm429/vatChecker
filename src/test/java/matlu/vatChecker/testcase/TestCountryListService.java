package matlu.vatChecker.testcase;

import matlu.vatChecker.AppException;
import matlu.vatChecker.Application;
import matlu.vatChecker.api.CountryListService;
import matlu.vatChecker.json.VatCountry;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

import org.springframework.web.client.RestTemplate;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class, initializers = ConfigFileApplicationContextInitializer.class)
public class TestCountryListService {

    @Autowired
    private CountryListService countryListService;

    @Autowired
    private RestTemplate restTemplate;

    private MockRestServiceServer mockServer;

    @Before
    public void init() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test(expected = AppException.class)
    public void testInvalidResponse() throws AppException {

        mockServer.expect( requestTo("http://jsonvat.com/"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body("invalid response"));

        List<VatCountry> countryList = countryListService.getCountryList();
    }
}
