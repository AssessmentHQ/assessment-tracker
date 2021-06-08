from selenium.webdriver.chrome.webdriver import WebDriver


class BatchHomePage:

    def __init__(self, driver: WebDriver):
        self.driver = driver

    def add_assessment_button(self):
        return self.driver.find_element_by_id("addAssessmentBtn")

    def assessment_type(self):
        return self.driver.find_element_by_id("assessment-type")

    def assessment_title(self):
        return self.driver.find_element_by_id("assessment-title")

    def create_assessment_button(self):
        return self.driver.find_element_by_xpath('//*[@id="createAssessmentForm"]/div[4]/button[1]')

    def close_assessment_button(self):
        return self.driver.find_element_by_xpath('//*[@id="createAssessmentForm"]/div[4]/button[2]')
