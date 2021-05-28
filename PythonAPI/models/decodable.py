from abc import ABC, abstractmethod


class Decodable(ABC):

    @staticmethod
    @abstractmethod
    def json_parse(json):
        pass

    @abstractmethod
    def json(self):
        pass
