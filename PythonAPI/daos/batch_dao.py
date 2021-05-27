from abc import abstractmethod, ABC


class BatchDAO(ABC):
    @abstractmethod
    def get_all_batches_by_year(self):
        pass

    @abstractmethod
    def get_batch_by_id(self, batch_id):
        pass
