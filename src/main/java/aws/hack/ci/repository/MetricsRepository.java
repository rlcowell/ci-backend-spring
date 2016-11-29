package aws.hack.ci.repository;


import aws.hack.ci.domain.DataPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by oleks on 11/28/2016.
 */
@Repository
@Transactional
public class MetricsRepository {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @PersistenceContext
  private EntityManager entityManger;


  public List<DataPoint> getSolrMetric(String country, String metric, String soilType) {
    String text =  "SELECT s.country,\n" +
      "       s.landscape_no AS landscape,\n" +
      "       l.description AS landscape_desc,\n" +
      "       AVG(" + metric + ") AS value\n" +
      "FROM public.eplotsoils_processed AS s\n" +
      "LEFT JOIN public.country AS c ON c.country = s.country\n" +
      "LEFT JOIN public.landscape AS l ON l.country = s.country AND l.landscape_no = s.landscape_no\n" +
      "WHERE soil_depth_class = :soilType\n" +
      "  AND s.country = :country \n" +
      "GROUP BY s.country, s.landscape_no, l.description\n" +
      "ORDER BY landscape_desc\n";
    Query query = entityManger.createNativeQuery(text, DataPoint.class);
    query.setParameter("country", country);
    query.setParameter("soilType", soilType);

    logger.info("query", text);
    return query.getResultList();
  }
}
