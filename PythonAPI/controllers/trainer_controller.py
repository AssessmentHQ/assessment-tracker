from flask import request, jsonify

from services.trainer_service import TrainerService
from utils.json_tool import convert_list_to_json


def route(app):

    @app.route("/trainer/", methods=["PUT"])
    def login():
        email = request.json["email"]
        return jsonify(TrainerService.login(email).json())

    @app.route("/trainer/<id>", methods=["GET"])
    def get_trainer_by_id(id):
        return jsonify(TrainerService.get_trainer_byID(id).json())

    @app.route("/trainers/<batch_id>", methods=["GET"])
    def get_trainers_by_batch_id(batch_id):
        return convert_list_to_json(TrainerService.get_trainers_in_batch(batch_id))