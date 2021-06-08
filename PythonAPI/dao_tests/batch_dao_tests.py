import unittest

from daos.daos_impl.batch_dao_impl import BatchDAOImpl
from exceptions.resource_not_found import ResourceNotFound


class DAOTests(unittest.TestCase):
    def test_get_all_batches_by_year(self):
        batches = BatchDAOImpl().get_all_batches_by_year(1, 2020)
        self.assertTrue(batches)

    def test_get_all_batches_by_year_fail(self):
        self.assertFalse(BatchDAOImpl().get_all_batches_by_year(1, 1))

    def test_get_batch_by_id(self):
        self.assertTrue(BatchDAOImpl().get_batch_by_id(1))

    def test_get_batch_by_id_fail(self):
        try:
            BatchDAOImpl().get_batch_by_id(10000)
            assert False
        except ResourceNotFound:
            assert True

    def test_search(self):
        batches = BatchDAOImpl().search_for_batch(1, "py")
        print(batches)
        assert batches

