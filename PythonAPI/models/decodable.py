from abc import ABC

import models.decodable


class Decodable(ABC):

    @staticmethod
    def json_parse(json) -> models.decodable.Decodable:
        pass

    def json(self):
        pass
