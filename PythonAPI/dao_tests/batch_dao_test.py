import unittest

from daos.batch_dao_impl import BatchDAOImpl


class DAOTests(unittest.TestCase):
    def test_get_all_batches_by_year(self):
        batches = BatchDAOImpl().get_all_batches_by_year('2020')
        self.assertTrue(batches)

