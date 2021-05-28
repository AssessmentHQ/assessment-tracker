from flask import request, jsonify

from services.trainer_service import TrainerService


def route(app):

    @app.route("/trainers/", methods=["PUT"])
    def login():
        email = request.json["email"]
        return jsonify(TrainerService.login(email).json())
