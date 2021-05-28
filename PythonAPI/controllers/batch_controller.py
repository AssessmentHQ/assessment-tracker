from flask import jsonify

from exceptions.resource_not_found import ResourceNotFound
from services.batch_services import BatchServices
from utils.json_tool import convert_list_to_json


def route(app):

    @app.route("/batch/<id>", methods=["GET"])
    def get_batch_by_id(id):
        """Takes in an id for a batch record and returns a Batch object"""
        return jsonify(BatchServices.get_batch_by_id(id).json())

    @app.route("/batches/<year>", methods=["GET"])
    def get_all_batches_by_year(year):
        """Takes in a year and returns all the batches currently in progress for that year"""
        batches = BatchServices.get_all_batches_by_year(year)
        batches_as_json = convert_list_to_json(batches)
        return jsonify(batches_as_json)
