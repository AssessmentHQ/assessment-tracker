import unittest

from daos.daos_impl.trainer_dao_impl import TrainerDAOImpl


class TrainerDAOTest(unittest.TestCase):

    def test_login(self):
        assert TrainerDAOImpl().login("rs@revature.com")