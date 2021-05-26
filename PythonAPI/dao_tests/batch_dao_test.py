import unittest

from daos.batch_dao_impl import BatchDAOImpl


class DAOTests(unittest.TestCase):
    # Batch DAO
    def test_get_all_batches(self):
        batches = BatchDAOImpl().get_all_batches()
        self.assertEqual(type(batches), type(None))
