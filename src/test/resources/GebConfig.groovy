import org.openqa.selenium.chrome.ChromeDriver

waiting {
    timeout = 10
}

environments {
    chrome {
        driver = {
            def driverInstance = new ChromeDriver()
            driverInstance.manage().window().maximize()
            driverInstance
        }
    }
}

reportsDir = 'target/geb-reports'