package aws.hack.ci.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by oleks on 11/28/2016.
 */
@Entity
public class DataPoint {

  @Id
  @Column(name = "country", nullable = false)
  public String country;

  @Column(name = "landscape", nullable = false)
  public String landscape;

  @Column(name = "value", nullable = false)
  public double value;

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getLandscape() {
    return landscape;
  }

  public void setLandscape(String landscape) {
    this.landscape = landscape;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "DataPoint{" +
      "country=" + country +
      ", landscape='" + landscape + '\'' +
      ", value='" + value + '\'' +
      '}';
  }
}
