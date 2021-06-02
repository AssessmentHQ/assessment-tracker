from flask import jsonify

from exceptions.resource_not_found import ResourceNotFound
from services.batch_services import BatchServices
from utils.json_tool import convert_list_to_json


def route(app):

    @app.route("/batch/<id>/", methods=["GET"])
    def get_batch_by_id(id):
        """Takes in an id for a batch record and returns a Batch object"""
        try:
            return jsonify(BatchServices.get_batch_by_id(int(id)).json())
        except ValueError as e:
            return "Not a valid ID or No such batch exist with this ID", 400  # Bad Request
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/batches/<trainer_id>/<year>/", methods=["GET"])
    def get_all_batches_by_year(trainer_id, year):
        """Takes in a year and returns all the batches currently in progress for that year"""
        try:
            batches = BatchServices.get_all_batches_by_year(int(trainer_id), int(year))
        except ValueError as e:
            return "Not a valid ID or No such batch exist with this ID", 400  # Bad Request
        batches_as_json = convert_list_to_json(batches)
        return jsonify(batches_as_json)
