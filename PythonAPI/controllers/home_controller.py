
def route(app):

    @app.route("/", methods=["GET"])
    def home():
        return "If you are seeing this, the app is running"
