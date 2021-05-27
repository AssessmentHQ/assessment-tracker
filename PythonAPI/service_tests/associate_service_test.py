import unittest

from daos.daos_impl.associate_dao_impl import AssociateDAOImpl
from models.associate import Associate
from services.associate_services import AssociateServices


associate_services = AssociateServices()


class AssociateTest(unittest.TestCase):
    def test_get_associate_by_id(self):
        assert associate_services.get_associated_byID(6)
