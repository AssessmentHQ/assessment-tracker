from abc import ABC, abstractmethod


class TrainerDAO(ABC):
    @abstractmethod
    def get_trainer_by_id(self, trainer_id):
        pass

    @abstractmethod
    def get_trainers_in_batch(self, trainer_id, batch_id):
        pass
