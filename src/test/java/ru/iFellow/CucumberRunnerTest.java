package ru.iFellow;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

import static io.cucumber.junit.platform.engine.Constants.FEATURES_PROPERTY_NAME;

@RunWith(Cucumber.class)
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("src/main/java/ru.iFellow/steps")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/HWF_API.feature")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "ru.iFellow.steps")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty, io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm")

public class CucumberRunnerTest {
}
