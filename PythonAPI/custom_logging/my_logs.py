import logging
import unittest


class MyLogger:

    logging.basicConfig(level=logging.INFO, filename='tuition_main.log', filemode='a',
                        format='%(name)s - %(levelname)s - %(message)s')
    formatter = logging.Formatter("%(asctime)s - %(levelname)s - %(message)s")

    console_handler = logging.StreamHandler()
    console_handler.setFormatter(formatter)
    logger = logging.getLogger(__name__)
    logger.addHandler(console_handler)

    @staticmethod
    def info(message="You have been informed"):
        MyLogger.logger.info(message)

    @staticmethod
    def warning(message="You have been warned"):
        MyLogger.logger.info(message)

    @staticmethod
    def error(message="An error has occurred"):
        MyLogger.logger.info(message)


class MyLoggerTest(unittest.TestCase):

    def test_log_levels(self):
        MyLogger.error("There is an error")
        MyLogger.info("Here is some info")
        MyLogger.warning("You have been warned")
        assert True
