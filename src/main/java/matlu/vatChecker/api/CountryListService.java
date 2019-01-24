package matlu.vatChecker.api;

import matlu.vatChecker.AppException;
import matlu.vatChecker.json.VatCountry;

import java.util.List;

public interface CountryListService {
    List<VatCountry> getCountryList() throws AppException;
}
