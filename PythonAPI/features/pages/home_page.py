from selenium.webdriver.chrome.webdriver import WebDriver


class HomePage:

    def __init__(self, driver: WebDriver):
        self.driver = driver

    def login_button(self):
        return self.driver.find_element_by_id("loginBtn")

    def login_credentials(self):
        return self.driver.find_element_by_id("recipient-email")
