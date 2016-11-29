package aws.hack.ci.controller;


import aws.hack.ci.domain.DataPoint;
import aws.hack.ci.repository.MetricsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleks on 11/28/2016.
 */
@RestController()
public class HackController {
  @Autowired
  MetricsRepository metricsRepository;

    @RequestMapping("/getByCountry")
  public List<DataPoint> getByCountry(@RequestParam String country) {
    return metricsRepository.getMetric();
  }

  @RequestMapping("/getByLandscape")
  public List<DataPoint> getByLandscape(
    @RequestParam String country,
    @RequestParam String landscape) {
    ArrayList<DataPoint> dataPoints = new ArrayList<>();
    DataPoint dataPoint = new DataPoint();
    dataPoint.country = "GHA";
    dataPoint.landscape = "L001";
    dataPoint.value = 1.1;
    dataPoints.add(dataPoint);
    return dataPoints;
  }
}
