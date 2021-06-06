from flask import jsonify

from exceptions.resource_not_found import ResourceNotFound
from services.associate_services import AssociateServices
from utils.json_tool import convert_list_to_json


def route(app):

    # Get associate by id endpoint
    @app.route("/associate/<associate_id>", methods=['GET'])
    def get_associate_id(associate_id):
        """Get a specific Associate by their ID"""
        try:
            batch = AssociateServices.get_associated_byID(int(associate_id))
            return jsonify(batch.json()), 200
        except ValueError as e:
            return "Not a valid ID or No such batch exist with this ID", 400  # Bad Request
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/associate/<associate_id>/<batch_id>", methods=['GET'])
    def get_associate_in_batch(associate_id, batch_id):
        """Get a specific Associate in the batch by their ID and a batch ID"""
        try:
            batch = AssociateServices.get_associate_in_batch(int(batch_id), int(associate_id))
            return jsonify(batch.json()), 200
        except ValueError as e:
            return "Not a valid ID or No such batch exist with this ID", 400  # Bad Request
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/associates/<batch_id>", methods=['GET'])
    def get_all_associates_in_batch(batch_id):
        """Get all Associates in a batch by the batch ID"""
        try:
            batch = AssociateServices.get_all_associates_in_batch(int(batch_id))
            batches_as_json = convert_list_to_json(batch)
            return jsonify(batches_as_json), 200
        except ValueError as e:
            return "Not a valid ID or No such batch exist with this ID", 400  # Bad Request
        except ResourceNotFound as r:
            return r.message, 404

