import unittest


from daos.daos_impl.associate_dao_impl import AssociateDAOImpl
from exceptions.resource_not_found import ResourceNotFound

associate_dao = AssociateDAOImpl()


class AssociateTest(unittest.TestCase):

    def test_get_associate_in_batch(self):
        assert associate_dao.get_associate_in_batch(6, 4)

    def test_get_associate_by_id(self):
        assert associate_dao.get_associate_by_id(5)

    def test_get_associate_in_batch_fail(self):
        try:
            associate_dao.get_associate_in_batch(200, 200)
            assert False
        except ResourceNotFound:
            assert True

    def test_get_associate_by_id_fail(self):
        try:
            associate_dao.get_associate_by_id(200)
        except ResourceNotFound:
            assert True
