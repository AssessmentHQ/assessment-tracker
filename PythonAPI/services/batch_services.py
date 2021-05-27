from daos.batch_dao import BatchDAO
from daos.daos_impl.batch_dao_impl import BatchDAOImpl


class BatchServices:
    batch_dao = BatchDAOImpl()

    @classmethod
    def get_batch_byID(cls, batch_id):
        return cls.batch_dao.get_batch_by_id(batch_id)
