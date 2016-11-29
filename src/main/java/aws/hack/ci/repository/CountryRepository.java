package aws.hack.ci.repository;

import aws.hack.ci.domain.AppCountry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<AppCountry, String> {
}
