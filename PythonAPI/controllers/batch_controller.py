from flask import jsonify

from exceptions.resource_not_found import ResourceNotFound
from services.batch_services import BatchServices


def route(app):
    @app.route("/associatebatch/<batch_id>", methods=['GET'])
    def get_associate_batch_id(batch_id):
        try:
            batch = BatchServices.get_batch_byID(int(batch_id))
            return jsonify(batch.json()), 200
        except ValueError as e:
            return "Not a valid ID or No such batch exist with this ID", 400  # Bad Request
        except ResourceNotFound as r:
            return r.message, 404
