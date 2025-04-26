import org.junit.Test;
import static org.junit.Assert.assertTrue;
import com.aventstack.extentreports.*;

import java.io.File;

public class SampleTest {

    @Test
    public void simpleTest() {
        ExtentReports extent = new ExtentReports();
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File("target/ExtentReports/report.html"));
        extent.attachReporter(reporter);

        ExtentTest test = extent.createTest("Dummy Test Case");
        test.pass("Test Passed Successfully!");

        extent.flush();

        assertTrue(true);
    }
}
