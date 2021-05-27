import unittest

from daos.daos_impl.trainer_dao_impl import TrainerDAOImpl


class DAOTests(unittest.TestCase):
    def test_get_trainer_by_id(self):
        trainers = TrainerDAOImpl().get_trainer_by_id(1)
        self.assertTrue(trainers)


    def test_get_trainers_in_batch(self):
        trainers = TrainerDAOImpl().get_trainers_in_batch(1, 1)
        self.assertTrue(trainers)