package aws.hack.ci.domain;

import javax.persistence.*;

@Entity
public class AppCountry {

    @Id
    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "name", nullable = false)
    private String name;

    public AppCountry() {
    }

    public AppCountry(String name) {
        this.name = name;
    }

    public AppCountry(String country, String name) {
        this.country = country;
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "country=" + country +
                ", name='" + name + '\'' +
                '}';
    }
}
