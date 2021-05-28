import unittest

from services.trainer_service import TrainerService


class TrainerServiceTest(unittest.TestCase):

    def test_login(self):
        assert TrainerService.login("rs@revature.com")