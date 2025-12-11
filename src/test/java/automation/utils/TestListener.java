package automation.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    public void onTestStart(ITestResult result)
    {
        LoggerUtils.logInfo("Test Started:"+result.getName());
    }
    public void onTestSuccess(ITestResult result)
    {
        LoggerUtils.logInfo("Test Success:"+result.getName());
    }
    public void onTestFailure(ITestResult result)
    {
        LoggerUtils.logInfo("Test Failure:"+result.getName());
    }
    public void onTestSkipped(ITestResult result)
    {
        LoggerUtils.logInfo("Test Skipped:"+result.getName());
    }
}
