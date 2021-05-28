
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
        sql = "select t.id, t.first_name, t.last_name, t.email " \
              "from trainers as t left join trainer_batches tb " \
              "on id = trainer_id where batch_id = %s"
        records = DbConn.make_connect(sql, [ batch_id])
        trainers = []
        for record in records:
            trainers.append(Trainer(id=record[0], first_name=record[1], last_name=record[2], email=record[3]))
        return trainers

    def login(self, email):
        sql = "SELECT * FROM trainers WHERE email=%s"
        records = DbConn.make_connect(sql, [email])
        if records:
            record = records[0]
            return Trainer(id=record[0], first_name=record[1], last_name=record[2], email=record[3])
        else:
            raise ResourceNotFound("No trainer exists with those credentials")


