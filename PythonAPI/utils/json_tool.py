import unittest

from flask import jsonify, Response

from exceptions.not_serializable import NotSerializableError
from models.decodable import Decodable


def convert_list_to_json(items: list[Decodable]) -> Response:
    """Pass in a list of objects that have a json method and receive a flask ready list"""
    json_list = []
    try:
        for item in items:
            json_list.append(item.json())
        return jsonify(json_list)
    except AttributeError:
        raise NotSerializableError("Items in list need to have a json method")


class UtilTest(unittest.TestCase):

    def test_convert_to_json_fail(self):
        list = ["hello", "world"]
        try:
            convert_list_to_json(list)
        except NotSerializableError:
            self.assertTrue(True)
