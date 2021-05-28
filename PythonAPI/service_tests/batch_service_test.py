import unittest

from daos.daos_impl.associate_dao_impl import AssociateDAOImpl
from models.batch import Batch
from daos.batch_dao import BatchDAO
from daos.daos_impl.batch_dao_impl import BatchDAOImpl
from services.batch_services import BatchServices

associate_dao = AssociateDAOImpl()


class BatchTest(unittest.TestCase):
    def test_get_associate_in_batch(self):
        assert associate_dao.get_associate_in_batch(6, 4)


