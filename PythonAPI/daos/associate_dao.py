from abc import abstractmethod, ABC


class AssociateDAO(ABC):

    @abstractmethod
    def get_associate_by_id(self, associate_id):
        pass

    @abstractmethod
    def get_associate_in_batch(self, associate_id, batch_id):
        pass
