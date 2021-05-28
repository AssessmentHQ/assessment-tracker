import unittest
from datetime import datetime
from math import floor


class Batch:

    def __init__(self,
                 name,
                 training_track,
                 start_date,
                 end_date,
                 id=-1):
        self.id = id
        self.name = name
        self.training_track = training_track
        self.start_date = start_date
        self.end_date = end_date

    def json(self):
        return {
            'batchId': self.id,
            'startDate': self.start_date,
            'endDate': self.end_date,
            'name': self.name,
            'trainingTrack': self.training_track,
            'currentWeek': self.current_week(),
            'totalWeeks': self.total_weeks()
        }

    @staticmethod
    def json_parse(json):
        batch = Batch()
        batch.id = json["batchId"]
        batch.start_date = json["startDate"]
        batch.end_date = json["endDate"]
        batch.name = json["name"]
        batch.training_track = json["trainingTrack"]
        return batch

    def current_week(self):
        """Returns the current week of training"""
        return floor(abs((datetime.now().date() - self.start_date).days / 7))

    def total_weeks(self):
        """Returns the total weeks of the training"""
        return floor(abs((self.end_date - self.start_date).days / 7))


class TestBatch(unittest.TestCase):

    def test_weeks_between(self):
        start = datetime.strptime("2021-05-20", "%Y-%m-%d")
        end = datetime.strptime("2021-06-20", "%Y-%m-%d")
        batch = Batch("New Batch", "Still dont know", start, end)
        print("start Year ",start.year)
        assert batch.current_week() == 4
