import unittest

from daos.daos_impl.trainer_dao_impl import TrainerDAOImpl
from exceptions.resource_not_found import ResourceNotFound


class DAOTests(unittest.TestCase):
    def test_get_trainer_by_id(self):
        trainers = TrainerDAOImpl().get_trainer_by_id(1)
        self.assertTrue(trainers)


    def test_get_trainers_in_batch(self):
        trainers = TrainerDAOImpl().get_trainers_in_batch(1)
        self.assertTrue(trainers)

    def test_login(self):
        self.assertTrue(TrainerDAOImpl().login("rs@revature.com"))

    def test_get_trainer_by_id_fail(self):
        try:
            trainer = TrainerDAOImpl().get_trainer_by_id(20000)
            assert False
        except ResourceNotFound:
            assert True


    def test_get_trainers_in_batch_fail(self):
        trainers = TrainerDAOImpl().get_trainers_in_batch(100)
        self.assertFalse(trainers)

    def test_login_fail(self):
        try:
            TrainerDAOImpl().login("loremipsum")
            assert False
        except ResourceNotFound:
            assert True

    def test_get_years_for_trainer(self):
        assert TrainerDAOImpl().get_years_for_trainer(1);