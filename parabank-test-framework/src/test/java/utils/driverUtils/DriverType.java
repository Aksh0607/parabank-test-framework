package utils.driverUtils;

import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public enum DriverType implements DriverSetup {
	
		

	FIREFOX {
		public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
			FirefoxOptions options = new FirefoxOptions();
			options.merge(capabilities);

			return new FirefoxDriver(options);
		}
	},
	CHROME {
		public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
			HashMap<String, Object> chromePreferences = new HashMap<>();

			chromePreferences.put("profile.password_manager_enabled", false);

			ChromeOptions options = new ChromeOptions();
			options.setHeadless(HEADLESS);
			options.merge(capabilities);
			options.addArguments("--no-default-browser-check");
			options.setExperimentalOption("prefs", chromePreferences);

			return new ChromeDriver(options);
		}
	},
	IE {
		public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.merge(capabilities);
			options.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
			options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);

			return new InternetExplorerDriver(options);
		}
	},
	EDGE {
		public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
			EdgeOptions options = new EdgeOptions();
			options.merge(capabilities);

			return new EdgeDriver(options);
		}
	};
	public final static boolean HEADLESS = Boolean.getBoolean("headless");
}