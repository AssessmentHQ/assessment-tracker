from daos.batch_dao import BatchDAO
from daos.daos_impl.associate_dao_impl import AssociateDAOImpl
from daos.daos_impl.batch_dao_impl import BatchDAOImpl


class BatchServices:
    #batch_dao = BatchDAOImpl()
    associate_dao = AssociateDAOImpl()

    # @classmethod
    # def get_associate_by_batch_id_and_associateid(cls, batch_id, associate_id):
    #     return cls.associate_dao.get_associate_in_batch(batch_id, associate_id)
