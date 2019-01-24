package matlu.vatChecker.api;

import matlu.vatChecker.json.VatCountry;

import java.util.List;

public interface CountryListProcessor {

    ProcessingResult process(List<VatCountry> countryList);
}
