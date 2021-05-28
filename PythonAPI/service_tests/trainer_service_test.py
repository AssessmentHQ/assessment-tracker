import unittest

from services.trainer_service import TrainerService


class TrainerServiceTest(unittest.TestCase):

    def test_login(self):
        assert TrainerService.login("rs@revature.com")

    def test_get_associate_by_id(self):
        assert TrainerService.get_trainer_byID(1)

    def test_get_trainers_by_batch_id(self):
        assert TrainerService.get_trainers_in_batch(1)