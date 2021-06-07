from abc import ABC, abstractmethod


class Codable(ABC):

    @staticmethod
    @abstractmethod
    def json_parse(json):
        pass

    @abstractmethod
    def json(self):
        pass
