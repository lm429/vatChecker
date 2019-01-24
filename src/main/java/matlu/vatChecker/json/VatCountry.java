package matlu.vatChecker.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import matlu.vatChecker.AppException;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VatCountry {

    private String name;
    private List<VatPeriod> periods;

    @JsonIgnore
    private Double standardRate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VatPeriod> getPeriods() {
        return periods;
    }

    public void setPeriods(List<VatPeriod> periods) {
        this.periods = periods;
    }

    public Double getStandardRate() {
        return standardRate;
    }

    public void setStandardRate(Double standardRate) {
        this.standardRate = standardRate;
    }

    public void findStandardRate() throws AppException {

        if ( periods == null || periods.size() == 0 ) {
            throw new AppException("No VAT periods for the country: " + getName());
        }

        VatPeriod period = periods.get(0);
        standardRate = period.getRates().get("standard");

        if ( standardRate == null ) {
            throw new AppException("No standard rate for the country: " + getName());
        }
    }
}
