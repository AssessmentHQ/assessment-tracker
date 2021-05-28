from abc import ABC


class Decodable(ABC):

    @staticmethod
    def json_parse(json):
        pass

    def json(self):
        pass
