from flask import jsonify

from exceptions.resource_not_found import ResourceNotFound
from services.associate_services import AssociateServices
from services.batch_services import BatchServices


def route(app):

    # Get associate by id endpoint
    @app.route("/associate/<associate_id>", methods=['GET'])
    def get_associate_id(associate_id: int):
        try:
            batch = AssociateServices.get_associated_byID(int(associate_id))
            return jsonify(batch.json()), 200
        except ValueError as e:
            return "Not a valid ID or No such batch exist with this ID", 400  # Bad Request
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/associate/<associate_id>/<batch_id>", methods=['GET'])
    def get_associate_in_batch(associate_id, batch_id):
        try:
            batch = AssociateServices.get_associate_in_batch(batch_id, associate_id)
            return jsonify(batch.json()), 200
        except ValueError as e:
            return "Not a valid ID or No such batch exist with this ID", 400  # Bad Request
        except ResourceNotFound as r:
            return r.message, 404

