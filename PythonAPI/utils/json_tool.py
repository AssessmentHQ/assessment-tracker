import unittest

from flask import jsonify

from exceptions.not_serializable import NotSerializableError


def convert_list_to_json(list):
    json_list = []
    try:
        for item in list:
            json_list.append(item.json())
        return jsonify(json_list)
    except AttributeError:
        raise NotSerializableError("Items in list need to have a json method")

class utilTest(unittest.TestCase):
    def test_convert_to_json_fail(self):
        list = ["hello", "world"]
        try:
            convert_list_to_json(list)
        except NotSerializableError:
            assert True