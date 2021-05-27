from models.trainer import Trainer
from utils.db_connection import DbConn


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
