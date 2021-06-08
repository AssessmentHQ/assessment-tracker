from daos.batch_dao import BatchDAO
from daos.daos_impl.associate_dao_impl import AssociateDAOImpl
from daos.daos_impl.batch_dao_impl import BatchDAOImpl
from models.batch import Batch


class BatchServices:

    @classmethod
    def get_batch_by_id(cls, batch_id):
        return BatchDAOImpl().get_batch_by_id(batch_id)

    @classmethod
    def get_all_batches_by_year(cls, trainer_id, year):
        return BatchDAOImpl().get_all_batches_by_year(trainer_id, year)

    @classmethod
    def search_for_batch(cls, trainer_id, track):
        return BatchDAOImpl().search_for_batch(trainer_id, track)

