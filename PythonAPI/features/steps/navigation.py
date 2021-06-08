from time import sleep

from behave import given, when, then

from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.select import Select


@given(u'The user is on home.html page')
def step_impl(context):
    driver = context.driver
    driver.get("http://34.204.173.118:5000/")
    # driver.get("file:///Users/kin/Desktop/assessment-tracker/web_files/home.html")
    sleep(3)


@when(u'The user clicks the login button')
def step_impl(context):
    context.home_page.login_button().click()
    sleep(2)


@when(u'They input their login credentials to the modal')
def step_impl(context):
    home_page = context.home_page
    home_page.login_credentials().send_keys("rs@revature.com")
    sleep(0.2)
    home_page.login_cred_button().click()
    sleep(3)


@when(u'The user clicks on a batch they wish to view')
def step_impl(context):
    home_page = context.home_page
    home_page.batch_button().click()
    sleep(2)


@then(u'The user will be on batch_home.html page')
def step_impl(context):
    assert context.driver.title == "Assessment Tracker - Batches by Week"


@when(u'The user adds an assessment to a batch week')
def step_impl(context):
    batch_home = context.batch_home
    batch_home.add_assessment_button().click()
    sleep(0.2)
    # batch_home.assessment_type().send_keys("1")
    select_object = Select(batch_home.assessment_type())
    select_object.select_by_value('2')
    batch_home.assessment_title().send_keys("Python Quiz")
    sleep(2)
    batch_home.create_assessment_button().click()
    batch_home.close_assessment_button().click()
    sleep(3)


@when(u'The user clicks on the created assessment')
def step_impl(context):
    assessments_page = context.assessments_page
    sleep(0.2)
    assessments_page.created_assessment().click()
    sleep(3)


@then(u'The user can be able to adjust the weight of the assessment')
def ste_impl(context):
    assessments_page = context.assessments_page
    driver = context.driver
    move = ActionChains(driver)
    move.click_and_hold(assessments_page.grade_slider()).move_by_offset(40, 0).release().perform()
    sleep(3)
    assessments_page.grade_weight_save().click()
    sleep(2)
