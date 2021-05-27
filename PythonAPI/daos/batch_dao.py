from abc import abstractmethod, ABC


class BatchDAO(ABC):
    @abstractmethod
    def get_all_batches_by_year(self):
        pass
