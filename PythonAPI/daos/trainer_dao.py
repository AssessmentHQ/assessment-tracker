from abc import ABC, abstractmethod


class TrainerDAO(ABC):


    @abstractmethod
    def get_trainer_by_id(self, trainer_id):
        pass

    @abstractmethod
    def get_trainers_in_batch(self, batch_id):
        pass

    @abstractmethod
    def login(self, email):
        pass

    @abstractmethod
    def get_years_for_trainer(self, trainer_id):
        pass

