package matlu.vatChecker.testcase;

import matlu.vatChecker.Application;
import matlu.vatChecker.api.ProcessingResult;
import matlu.vatChecker.api.CountryListProcessor;
import matlu.vatChecker.json.VatCountry;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class, initializers = ConfigFileApplicationContextInitializer.class)

public class TestCountryProcessor {

    private static final double[] TEST_DATA   = { 5.0, 2.0, 1.0, 3.0, 4.0 };

    @Autowired
    private CountryListProcessor countryListProcessor;

    @Test
    public void testProcessor() {

        List<VatCountry> list = new ArrayList<>();
        for (int i=0; i<TEST_DATA.length; i++) {
            VatCountry c = new VatCountry();
            c.setStandardRate(TEST_DATA[i]);
            list.add(c);
        }

        ProcessingResult result = countryListProcessor.process(list);

        Assert.assertTrue(result.getLowestVatCountries().get(0).getStandardRate() == 1.0 );
        Assert.assertTrue(result.getLowestVatCountries().get(1).getStandardRate() == 2.0 );
        Assert.assertTrue(result.getLowestVatCountries().get(2).getStandardRate() == 3.0 );
    }
}
