package aws.hack.ci.controller;

import aws.hack.ci.domain.AppCountry;
import aws.hack.ci.domain.AppUser;
import aws.hack.ci.repository.CountryRepository;
import aws.hack.ci.repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeController {

  @Inject
  UserRepository userRepository;

  @Inject
  CountryRepository countryRepository;


  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String sayHello() {
    return "Hello there !";
  }

  @RequestMapping(value = "/user/{username}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public AppUser create(@PathVariable String username) {
    return userRepository.save(new AppUser(username));
  }

  @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<AppUser> findAll() {
    final List<AppUser> resultList = new ArrayList<>();
    final Iterable<AppUser> all = userRepository.findAll();
    all.forEach(new Consumer<AppUser>() {
      @Override
      public void accept(AppUser appUser) {
        resultList.add(appUser);
      }
    });
    return resultList;
  }

  @RequestMapping(value = "/country/{country}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public AppCountry createCountry(@PathVariable String country) {
    return countryRepository.save(new AppCountry(country));
  }

  @RequestMapping(value = "/country", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<AppCountry> findCountryAll() {
    final List<AppCountry> resultList = new ArrayList<>();
    final Iterable<AppCountry> all = countryRepository.findAll();
    all.forEach(new Consumer<AppCountry>() {
      @Override
      public void accept(AppCountry appCountry) {
        resultList.add(appCountry);
      }
    });
    return resultList;
  }

  @RequestMapping(value = "/metrics", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<AppCountry> findDataPoints() {
    final List<AppCountry> resultList = new ArrayList<>();
    final Iterable<AppCountry> all = countryRepository.findAll();
    all.forEach(new Consumer<AppCountry>() {
      @Override
      public void accept(AppCountry appCountry) {
        resultList.add(appCountry);
      }
    });
    return resultList;
  }

}
