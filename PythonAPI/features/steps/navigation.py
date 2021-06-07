from time import sleep

from behave import given, when, then

from selenium.webdriver.common.action_chains import ActionChains


@given(u'The user is on home.html page')
def step_impl(context):
    driver = context.driver
    driver.get("G:/RevatureWork/assessment-tracker/web_files/home.html")
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
    batch_home.assessment_type().send_keys("1")
    batch_home.assessment_title().send_keys("Python Quiz")
    sleep(0.2)
    batch_home.create_assessment_button().click()
    sleep(3)


@when(u'The user clicks on the created assessment')
def step_impl(context):
    assessments_page = context.assessments_page
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
