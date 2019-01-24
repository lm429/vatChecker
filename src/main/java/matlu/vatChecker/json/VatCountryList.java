package matlu.vatChecker.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VatCountryList {

    private String details;
    private String version;
    private List<VatCountry> rates;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<VatCountry> getRates() {
        return rates;
    }

    public void setRates(List<VatCountry> rates) {
        this.rates = rates;
    }
}
