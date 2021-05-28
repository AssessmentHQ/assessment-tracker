class Trainer:

    def  __init__(self, first_name, last_name, email, role="", id=-1):
        self.id = id
        self.first_name = first_name
        self.last_name = last_name
        self.email = email
        self.role = role

    def json(self):
        return {
            'id': self.id,
            'email': self.email,
            'first_name': self.first_name,
            'last_name': self.last_name,
            'role': self.role,
        }

    @staticmethod
    def json_parse(json):
        trainer = Trainer()
        trainer.id = json["id"]
        trainer.email = json["email"]
        trainer.first_name = json["first_name"]
        trainer.last_name = json["last_name"]
        trainer.role = json["role"]
        return trainer
