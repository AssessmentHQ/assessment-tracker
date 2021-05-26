class Trainer:

    def __init__(self, first_name, last_name, email, role="", id=-1):
        self.id = id
        self.first_name = first_name
        self.last_name = last_name
        self.email = email
        self.role = role