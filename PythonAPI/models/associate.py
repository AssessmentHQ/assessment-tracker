class Associate:

    def __init__(self, first_name, last_name, email, training_status, id=-1):
        self.id = id
        self.first_name = first_name
        self.last_name = last_name
        self.email = email
        self.training_status = training_status

    def json(self):
        return {
            'id': self.id,
            'email': self.email,
            'firstName': self.first_name,
            'lastName': self.last_name,
            'trainingStatus': self.training_status,
        }

    @staticmethod
    def json_parse(json):
        associate = Associate()
        associate.id = json["id"]
        associate.email = json["email"]
        associate.first_name = json["firstName"]
        associate.last_name = json["lastName"]
        associate.training_status = json["trainingStatus"]
        return associate
