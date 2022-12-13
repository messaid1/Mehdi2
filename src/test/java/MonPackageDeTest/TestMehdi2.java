package MonPackageDeTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class TestMehdi2 {
    private WebDriver driver;

    @BeforeEach
    public void TestSetUp() {
        System.setProperty("webdriver.chrome.driver",   "/tmp/chromedriver.exe");
        Map<String, Object> prefs = new HashMap<>();
        // permet tous les cookies pour Chrome, en deux étapes :
        // 1 - allow all cookies
        prefs.put("profile.default_content_setting_values.cookies", 1);
        // 2 - bloque seulement les cookies tiers : non
        prefs.put("profile.block_third_party_cookies", false);
        // Meme chose, pour Firefox
        prefs.put("network.cookie.cookieBehavior", 0);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1920x1080", "--headless", "--no-sandbox");
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void TestTearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Test unique Mehdi")
    public void testUniqueMehdi() {
        driver.get("http://www.google.fr");
        driver.manage().window().maximize();
    }
}
