from abc import abstractmethod, ABC

from models.batch import Batch


class BatchDAO(ABC):

    @abstractmethod

    def get_all_batches_by_year(self, year):]
    def get_all_batches_by_year(self, year):

    def get_all_batches_by_year(self, year: int) -> list[Batch]:
        pass

    @abstractmethod
    def get_batch_by_id(self, batch_id: int) -> Batch:
        pass
