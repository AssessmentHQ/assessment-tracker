from selenium import webdriver
from selenium.webdriver.chrome.webdriver import WebDriver


def before_all(context):
    driver: WebDriver = webdriver.Chrome("G:\RevatureWork\SeleniumDrivers\chromedriver.exe")
    context.driver = driver


def after_all(context):
    context.driver.quit()
