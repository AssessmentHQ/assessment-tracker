import unittest

from models.batch import Batch
from daos.batch_dao import BatchDAO
from daos.daos_impl.batch_dao_impl import BatchDAOImpl
from services.batch_services import BatchServices

batch_dao = BatchDAOImpl()
batch_services = BatchServices()
test_batch_donald = Batch(2, '2020-04-20', '2021-03-10', 'Donald', 'Trainer')


class BatchTest(unittest.TestCase):
    def test_get_batch_by_id(self):
        retrieved_batch = batch_services.get_batch_byID(2)
        assert test_batch_donald.name == retrieved_batch.name
