
from daos.trainer_dao import TrainerDAO
from models.batch import Batch
from models.trainer import Trainer
from utils.db_connection import DbConn



class TrainerDAOImpl(TrainerDAO):

    def get_trainer_by_id(self, trainer_id):
        sql = "SELECT * FROM trainers WHERE id=%s"
        records = DbConn.make_connect(sql, [trainer_id])
        record = records[0]
        if record:
            return Trainer(id=record[0], first_name=record[1], last_name=record[2], email=record[3])
        else:
            f"Trainer with id: {trainer_id} - Not Found"

    def get_trainers_in_batch(self, trainer_id, batch_id):
        sql = "select t.id, t.first_name, t.last_name, t.email" \
              "from trainers as t left join trainer_batches tb " \
              "on id = trainer_id where trainer_id = %s and batch_id = %s"
        records = DbConn.make_connect(sql, [trainer_id, batch_id])
        record = records[0]

        if record:
            return Trainer(id=record[0], first_name=record[1], last_name=record[2], email=record[3])
        else:
            f"Trainer with {trainer_id} and {batch_id} Not Found "

class TrainerDAOImpl():

    def login(self, email):
        sql = "Select * from trainers where email = %s"

        records = DbConn.make_connect(sql, [email])

        # this should only return 1
        try:
            record = records[0]
        except IndexError:
            return "No record was found"
        return Trainer(id=record[0], email=record[1], first_name=record[2], last_name=record[3])

