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

    def current_week(self):
        return floor(abs((datetime.now() - self.start_date).days / 7))

    def total_weeks(self):
        return floor(abs((self.end_date - self.start_date).days / 7))


class TestBatch(unittest.TestCase):

    def test_weeks_between(self):
        start = datetime.strptime("2021-05-20", "%Y-%m-%d")
        end = datetime.strptime("2021-06-20", "%Y-%m-%d")
        batch = Batch("New Batch", "Still dont know", start, end)
        assert batch.current_week() == 4
