from datetime import datetime
from math import floor


class Batch:

    def __init__(self,
                 name,
                 training_track,
                 start_date,
                 end_date,
                 associates=None,
                 trainers=None):
        self.associates = associates if associates else []
        self.trainers = trainers if trainers else []
        self.name = name
        self.training_track = training_track
        self.start_date = start_date
        self.end_date = end_date

    def weeks_between(self):
        d1 = datetime.strptime(self.start_date, "%Y-%m-%d")
        d2 = datetime.strptime(self.end_date, "%Y-%m-%d")
        return floor(abs((d2 - d1).days / 7))