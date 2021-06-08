from flask import render_template


def route(app):

    @app.route("/home", methods=["GET"])
    def home():
        return render_template("home.html")

    @app.route("/", methods=["GET"])
    def home():
        return render_template("home.html")

    @app.route("/batch")
    def batches():
        return render_template("batch_home.html")