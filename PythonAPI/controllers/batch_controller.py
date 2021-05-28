from flask import jsonify

from exceptions.resource_not_found import ResourceNotFound
from services.batch_services import BatchServices
from utils.json_tool import convert_list_to_json


def route(app):

    @app.route("/batch/<id>", methods=["GET"])
    def get_batch_by_id(id):
        return jsonify(BatchServices.get_batch_by_id(id).json())

    @app.route("/batches/<year>", methods=["GET"])
    def get_all_batches_by_year(year):
        return convert_list_to_json(BatchServices.get_all_batches_by_year(year))
