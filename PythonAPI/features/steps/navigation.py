from time import sleep

from behave import given, when, then


@given(u'The user is on home.html page')
def step_impl(context):
    driver = context.driver
    # driver.get("G:/RevatureWork/assessment-tracker/web_files/home.html")
    driver.get("file:///Users/kin/Desktop/assessment-tracker/web_files/home.html")
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
    batch_home.create_assessment_button().click()
    sleep(3)
