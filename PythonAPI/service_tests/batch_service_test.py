import unittest

from services.batch_services import BatchServices


class BatchTest(unittest.TestCase):

    def test_get_batch_by_id(self):
        assert BatchServices.get_batch_by_id(1)

    def test_get_all_batches_by_year(self):
        assert BatchServices.get_all_batches_by_year(2020)


