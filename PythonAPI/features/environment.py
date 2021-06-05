from selenium import webdriver
from selenium.webdriver.chrome.webdriver import WebDriver

from features.pages.assessments import AssessmentsPage
from features.pages.batch_home_page import BatchHomePage
from features.pages.home_page import HomePage


def before_all(context):
    driver: WebDriver = webdriver.Chrome("G:\RevatureWork\SeleniumDrivers\chromedriver.exe")
    home_page: HomePage = HomePage(driver)
    batch_home: BatchHomePage = BatchHomePage(driver)
    assessments_page: AssessmentsPage = AssessmentsPage(driver)
    context.driver = driver
    context.home_page = home_page
    context.batch_home = batch_home
    context.assessments_page = assessments_page


def after_all(context):
    context.driver.quit()
