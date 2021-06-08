from flask import Flask
from controllers import app_controller

app = Flask(__name__)

app_controller.route(app)

if __name__ == '__main__':
    app.run()
