package EdujiraiFellow.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/HW4.feature",
        glue = {"EdujiraiFellow.steps", "EdujiraiFellow.hooks"},
        plugin = {"pretty"}
)

public class TestClass {
}
