from flask_cors import CORS
from controllers import batch_controller, associate_controller, trainer_controller


def route(app):
    batch_controller.route(app)
    associate_controller.route(app)
    trainer_controller.route(app)
    CORS(app)
