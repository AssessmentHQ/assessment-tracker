from math import floor

from daos.trainer_dao import TrainerDAO
from exceptions.resource_not_found import ResourceNotFound
from models.batch import Batch
from models.trainer import Trainer
from utils.db_connection import DbConn


class TrainerDAOImpl(TrainerDAO):

    def get_trainer_by_id(self, trainer_id):
        sql = "SELECT * FROM trainers WHERE id=%s"
        records = DbConn.make_connect(sql, [trainer_id])
        if records:
            record = records[0]
            return Trainer(id=record[0], first_name=record[1], last_name=record[2], email=record[3])
        else:
            raise ResourceNotFound("No trainer could be found with the given id")

    def get_trainers_in_batch(self, batch_id):
        sql = "select t.id, t.first_name, t.last_name, t.email, tb.role " \
              "from trainers as t left join trainer_batches tb " \
              "on id = trainer_id where batch_id = %s"
        records = DbConn.make_connect(sql, [batch_id])
        trainers = []
        for record in records:
            trainers.append(Trainer(id=record[0],
                                    first_name=record[1],
                                    last_name=record[2],
                                    email=record[3],
                                    role=record[4]))
        return trainers

    def login(self, email):
        sql = "SELECT * FROM trainers WHERE email=%s"
        records = DbConn.make_connect(sql, [email])
        if records:
            record = records[0]
            return Trainer(id=record[0], first_name=record[2], last_name=record[3], email=record[1])
        else:
            raise ResourceNotFound("No trainer exists with those credentials")

    def get_years_for_trainer(self, trainer_id):
        """Takes in a year and returns all the batches currently in progress for that year"""
        sql = "SELECT date_part('year', b.start_date) " \
              "FROM batches as b " \
              "left join trainer_batches as tb " \
              "on b.id = tb.batch_id " \
              "WHERE trainer_id = %s"
        records = DbConn.make_connect(sql, [trainer_id])
        years = set()
        for year in records:
            years.add(floor(year[0]))

        return years
