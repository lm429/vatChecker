package matlu.vatChecker.api;

import matlu.vatChecker.json.VatCountry;

import java.util.List;

public class ProcessingResult {

    private List<VatCountry> lowestVatCountries;
    private List<VatCountry> highestVatCountries;

    public List<VatCountry> getLowestVatCountries() {
        return lowestVatCountries;
    }

    public void setLowestVatCountries(List<VatCountry> lowestVatCountries) {
        this.lowestVatCountries = lowestVatCountries;
    }

    public List<VatCountry> getHighestVatCountries() {
        return highestVatCountries;
    }

    public void setHighestVatCountries(List<VatCountry> highestVatCountries) {
        this.highestVatCountries = highestVatCountries;
    }
}
