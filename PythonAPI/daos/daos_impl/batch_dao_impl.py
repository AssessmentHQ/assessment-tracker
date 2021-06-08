from math import floor

from daos.batch_dao import BatchDAO
from exceptions.resource_not_found import ResourceNotFound
from models.batch import Batch
from utils.db_connection import DbConn


class BatchDAOImpl(BatchDAO):

    def get_batch_by_id(self, batch_id):
        """Takes in an id for a batch record and returns a Batch object"""
        sql = "SELECT * FROM batches where id=%s"
        records = DbConn.make_connect(sql, [batch_id])
        if records:
            record = records[0]
            return Batch(id=record[0], start_date=record[1], end_date=record[2], name=record[3],
                         training_track=record[4])
        else:
            raise ResourceNotFound("No batch could be found with the given id")

    def get_all_batches_by_year(self, trainer_id, year):
        """Takes in a year and returns all the batches currently in progress for that year"""
        sql = "SELECT b.id, b.start_date, b.end_date, b.name, b.training_track " \
              "FROM batches as b " \
              "left join trainer_batches as tb " \
              "on b.id = tb.batch_id " \
              "WHERE trainer_id = %s and date_part('year', b.start_date) = %s"
        records = DbConn.make_connect(sql, [trainer_id, year])
        batches = []
        for batch in records:
            batches.append(Batch(id=batch[0], start_date=batch[1], end_date=batch[2], name=batch[3], training_track=batch[4]))
        return batches

    def search_for_batch(self, trainer_id, track):
        """Searches for batch by trainer and track"""
        sql = "SELECT b.id, b.start_date, b.end_date, b.name, b.training_track " \
              "FROM batches as b " \
              "left join trainer_batches as tb " \
              "on b.id = tb.batch_id " \
              "WHERE trainer_id = %s and LOWER(training_track) like LOWER(%s)"

        records = DbConn.make_connect(sql, [trainer_id, track + "%"])
        batches = []
        for batch in records:
            batches.append(Batch(id=batch[0], start_date=batch[1], end_date=batch[2], name=batch[3], training_track=batch[4]))
        return batches