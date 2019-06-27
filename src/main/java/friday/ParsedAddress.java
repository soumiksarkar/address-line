package friday;

import java.util.Objects;

public class ParsedAddress {

    private String street;

    private String housenumber;

    ParsedAddress(String street, String housenumber) {
        this.street = street;
        this.housenumber = housenumber;
    }

    @Override
    public String toString() {
        return "ParsedAddress{" +
                "street='" + street + '\'' +
                ", housenumber='" + housenumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParsedAddress that = (ParsedAddress) o;
        return street.equals(that.street) &&
                housenumber.equals(that.housenumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, housenumber);
    }
}
