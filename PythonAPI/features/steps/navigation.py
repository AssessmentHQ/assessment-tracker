from time import sleep

from behave import given, when, then


@given(u'The user is on home.html page')
def step_impl(context):
    driver = context.driver
    driver.get("G:/RevatureWork/assessment-tracker/web_files/home.html")


@when(u'The user clicks the login button')
def step_impl(context):
    context.home_page.login_button().click()
    sleep(0.2)
    context.home_page.login_credentials().send_keys("rs@revature.com")
    sleep(5)


@when(u'They input their login credentials to the modal')
def step_impl(context):
    raise NotImplementedError(u'STEP: When They input their login credentials to the modal')


@then(u'The user will be on batch_home.html page')
def step_impl(context):
    raise NotImplementedError(u'STEP: Then The user will be on batch_home.html page')


@when(u'The user filters the batches by year')
def step_impl(context):
    raise NotImplementedError(u'STEP: When The user filters the batches by year')


@when(u'Clicks on the batch they wish to see in that year')
def step_impl(context):
    raise NotImplementedError(u'STEP: When Clicks on the batch they wish to see in that year')


@then(u'The user will be on the specific_batch.html page')
def step_impl(context):
    raise NotImplementedError(u'STEP: Then The user will be on the specific_batch.html page')


@when(u'The user clicks on the week of the batch they wish to view')
def step_impl(context):
    raise NotImplementedError(u'STEP: When The user clicks on the week of the batch they wish to view')


@then(u'The user will be on the specific_batch_week.html page')
def step_impl(context):
    raise NotImplementedError(u'STEP: Then The user will be on the specific_batch_week.html page')
