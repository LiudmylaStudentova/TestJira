package test;

import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewIssuePage;
import test.BaseTest;

public class JIRATest extends BaseTest {

    @Feature("Login")
    @Test(groups = {"Regression"})
    public void createIssueTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.Login("webinar5", "webinar5");
        Assert.assertEquals(driver.getCurrentUrl(), "https://jira.hillel.it/secure/Dashboard.jspa");
    }

    @Feature("Issue")
    @Test(groups = {"Regression", "SKIP"})
    public void createIssue() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.Login("webinar5", "webinar5");
        Assert.assertEquals(driver.getCurrentUrl(), "https://jira.hillel.it/secure/Dashboard.jspa");

        NewIssuePage createIssuePage = new NewIssuePage(driver);

        createIssuePage.clickCreateNewIssueButton();

        createIssuePage.enterProjectName("QAAUTO-8 (QAAUT8)");

        createIssuePage.enterIssueType("Test");

        createIssuePage.enterIssueSummary("This is an automatic test for QA Automations.");

        createIssuePage.enterIssueDescription("This is an automatic test for QA Automations.");

        createIssuePage.clickCreateIssue();

        Assert.assertTrue(createIssuePage.issueCreatedPopupPresent());
    }

    @Feature("Issue")
    @Test(groups = {"Regression", "SKIP"})
    public void testToBeSkipped() throws InterruptedException {
    }
    }