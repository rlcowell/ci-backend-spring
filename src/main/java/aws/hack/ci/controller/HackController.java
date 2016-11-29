package aws.hack.ci.controller;


import aws.hack.ci.domain.DataPoint;
import aws.hack.ci.repository.MetricsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleks on 11/28/2016.
 */
@RestController()
@CrossOrigin(origins = {"http://localhost:9095", "http://54.91.246.118:9095", "http://localhost", "http://54.91.246.118"})
public class HackController {
  @Autowired
  MetricsRepository metricsRepository;

  @RequestMapping("/getSoilMetricByCountry")

  public List<DataPoint> getByCountry(@RequestParam String country, @RequestParam String metric, @RequestParam String soilType) {
    return metricsRepository.getSolrMetric(country, metric, soilType);
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
