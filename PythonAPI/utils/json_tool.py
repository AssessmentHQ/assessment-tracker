import unittest

from flask import jsonify, Response

from exceptions.not_serializable import NotSerializableError
from models.associate import Associate


def convert_list_to_json(items):
    """Pass in a Decodable object and recieve a dictionary ready to be jsonified"""
    json_list = []
    try:
        for item in items:
            json_list.append(item.json())
        return json_list
    except AttributeError:
        raise NotSerializableError("Items in list need to have a json method")


class UtilTest(unittest.TestCase):

    def test_convert_to_json_fail(self):
        list = ["hello", "world"]
        try:
            convert_list_to_json(list)
        except NotSerializableError:
            self.assertTrue(True)

    def test_convert_to_json_list(self):
        list = [Associate(first_name="a", last_name="a", email="a", training_status="a"),
                Associate(first_name="a", last_name="a", email="a", training_status="a")]
        self.assertTrue(convert_list_to_json(list))
