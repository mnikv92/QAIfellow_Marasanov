package EdujiraiFellow;

import io.cucumber.junit.platform.engine.Constants;;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.FEATURES_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("src/main/java/EdujiraiFellow/steps")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/HW4.feature")
//@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "EdujiraiFellow/hooks")
//@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@login")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
//@ConfigurationParameter(key = Constants.FILTER_NAME_PROPERTY_NAME, value = ".*тест")

public class CucumberRunnerTest {
}
