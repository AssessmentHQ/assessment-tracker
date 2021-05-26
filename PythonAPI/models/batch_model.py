class Batch:
    def __init__(self, name=None, training_track=None, start_date=None, end_date=None, id=None):
        self.id = id
        self.name = name
        self.training_track = training_track
        self.start_date = start_date
        self.end_date = end_date


    def json(self):
        return {
            "Id": self.id,
            'Name': self.name,
            'trainingTrack':   self.training_track,
            'startDate': self.start_date,
            "endDate": self.end_date
        }

    @staticmethod
    def json_parse(json):
        batches = Batch()
        batches.id = json['Id'] if "id" in json else None
        batches.name = json['Name'] if "name" in json else None
        batches.training_track = json['trainingTrack'] if "training_track" in json else None
        batches.start_date = json['startDate'] if "start_date" in json else None
        batches.end_date = json["endDate"] if "end_date" in json else None
        return batches
