from abc import abstractmethod, ABC

from models.batch import Batch


class BatchDAO(ABC):

    @abstractmethod
    def get_all_batches_by_year(self, trainer_id, year):
        pass
    def get_all_batches_by_year(self, year):
        pass

    def get_all_batches_by_year(self, year: int) -> list[Batch]:
        pass

    def get_all_batches_by_year(self, year):
        pass

    @abstractmethod
    def get_batch_by_id(self, batch_id):
        pass
