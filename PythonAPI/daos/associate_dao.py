from abc import abstractmethod, ABC


class AssociateDAO(ABC):
    @abstractmethod
    def get_associate_by_id(self, associate_id):
        pass