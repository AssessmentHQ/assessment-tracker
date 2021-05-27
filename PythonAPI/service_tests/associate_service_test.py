import unittest

from daos.daos_impl.associate_dao_impl import AssociateDAOImpl
from models.associate import Associate
from services.associate_services import AssociateServices

associate_dao = AssociateDAOImpl()
associate_services = AssociateServices()

test_get_associate_byid = Associate(1, 'donald@project3.com', 'Donald', 'Nteh')


class AssociateTest(unittest.TestCase):
    def test_get_associate_by_id(self):
        retrieved_associate = associate_services.get_associated_byID(1)
        assert test_get_associate_byid.id == retrieved_associate.id


