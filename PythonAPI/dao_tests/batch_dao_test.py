import unittest

from daos import batch_dao
from daos.batch_dao import BatchDAO
from daos.batch_dao_impl import BatchDAOImpl
from models.batch_model import Batch


class DAOTests(unittest.TestCase):
    def test_get_all_batches_by_year(self):
        batches = BatchDAOImpl().get_all_batches_by_year('2020')
        self.assertTrue(batches)

