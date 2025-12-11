package automation.utils;


    import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

    public class ExtentManager {

        private static ExtentReports extent;

        // Private constructor to prevent instantiation
        private ExtentManager() {}

        public static ExtentReports getInstance() {
            if (extent == null) {
                String reportPath = "src/test/resources/Reports/ExtentReport.html";
                ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

                // Reporter configuration
                sparkReporter.config().setDocumentTitle("Automation Report");
                sparkReporter.config().setReportName("Regression Suite");
                sparkReporter.config().setTheme(Theme.STANDARD);

                extent = new ExtentReports();
                extent.attachReporter(sparkReporter);

                // Add system info
                extent.setSystemInfo("OS", System.getProperty("os.name"));
                extent.setSystemInfo("Tester", "Greeshma");
                extent.setSystemInfo("Browser", "Chrome");
            }
            return extent;
        }}


