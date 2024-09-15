package api.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	ExtentSparkReporter spark;
	ExtentReports extent;
	ExtentTest test;
	String reportName;

	public void onStart(ITestContext context) {

		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		reportName = "Execution Report - " + timestamp + ".html";
		spark = new ExtentSparkReporter(".//Reports//" + reportName);
		spark.config().setDocumentTitle("Report's Document Title");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName("Report Name");
		extent = new ExtentReports();
		extent.setSystemInfo("Application", "Petstore");
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Environment", "UAT");
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test Passed");

	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.FAIL, "Test FAILED");

	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.SKIP, "Test SKIPPED");
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
