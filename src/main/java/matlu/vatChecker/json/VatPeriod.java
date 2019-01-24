package matlu.vatChecker.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VatPeriod {

    private Date effective_from;
    private Map<String, Double> rates = new HashMap<>();

    public Date getEffective_from() {
        return effective_from;
    }

    public void setEffective_from(Date effective_from) {
        this.effective_from = effective_from;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
