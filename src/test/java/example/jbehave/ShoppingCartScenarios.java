package example.jbehave;

/**
 * 
 * @author Naeem Tahir
 *
 */
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.PassingUponPendingStep;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public class ShoppingCartScenarios extends JUnitStory {

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryParser(new RegexStoryParser(new ExamplesTableFactory(new LoadFromClasspath(getClass()))))
                // story files location
                .useStoryLoader(new LoadFromClasspath(getClass()))
                // reporting configuration
                .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE, Format.HTML))
                // failure strategy
                .useFailureStrategy(new PassingUponPendingStep());
    }

    // Here we specify the steps classes
    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new ShoppingCartSteps());        
    }
    
}
