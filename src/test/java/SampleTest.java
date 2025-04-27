import org.junit.Test;
import static org.junit.Assert.assertTrue;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter; 

import java.io.File;

public class SampleTest {

    @Test
    public void simpleTest() {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter(new File("target/ExtentReports/index.html")); // <-- Correct path and file name
        extent.attachReporter(reporter);

        ExtentTest test = extent.createTest("Dummy Test Case");
        test.pass("Test Passed Successfully!");

        extent.flush(); // VERY important to save the report

        assertTrue(true);
    }
}
