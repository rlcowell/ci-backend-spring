package aws.hack.ci.repository;


import aws.hack.ci.domain.DataPoint;
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

  @PersistenceContext
  private EntityManager entityManger;


  public List<DataPoint> getSolrMetric(String country, String metric, String soilType) {
    Query query = entityManger.createNativeQuery(
      "SELECT s.country,\n" +
        "       s.landscape_no AS landscape,\n" +
        "       l.description AS landscape_desc,\n" +
        "       AVG(" + metric + ") AS value\n" +
        "FROM public.eplotsoils_processed AS s\n" +
        "LEFT JOIN public.country AS c ON c.country = s.country\n" +
        "LEFT JOIN public.landscape AS l ON l.country = s.country AND l.landscape_no = s.landscape_no\n" +
        "WHERE soil_depth_class = :soilType\n" +
        "  AND s.country = :country \n" +
        "GROUP BY s.country, s.landscape_no, l.description\n" +
        "ORDER BY landscape_desc\n",
      DataPoint.class);
    query.setParameter("country", country);
    query.setParameter("soilType", soilType);
    return query.getResultList();
  }
}
