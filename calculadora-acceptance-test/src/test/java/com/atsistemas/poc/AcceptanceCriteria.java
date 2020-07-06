package com.atsistemas.poc;

import com.intuit.karate.junit4.Karate;
import cucumber.api.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;


@RunWith(Karate.class)
@CucumberOptions(features = "classpath:karate")
public class AcceptanceCriteria {

    @BeforeClass
    public static void setUp() {
        LauncherApp.run(new String[]{"--server.port=" + 8090});
        configureFor("localhost", 8090);
    }

}
