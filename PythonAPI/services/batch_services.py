from daos.batch_dao import BatchDAO
from daos.daos_impl.associate_dao_impl import AssociateDAOImpl
from daos.daos_impl.batch_dao_impl import BatchDAOImpl


class BatchServices:

    @classmethod
    def get_batch_by_id(cls, batch_id):
        return BatchDAOImpl().get_batch_by_id(batch_id)

    @classmethod
    def get_all_batches_by_year(cls, year):
        return BatchDAOImpl().get_all_batches_by_year(year)