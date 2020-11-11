package testRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@Cucumber.Options(features="MyApplication.feature",glue={"testRunner"})
public class Testloginpage {

}
