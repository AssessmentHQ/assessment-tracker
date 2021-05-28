from daos.associate_dao import AssociateDAO
from models.associate import Associate
from utils.db_connection import DbConn


class AssociateDAOImpl(AssociateDAO):
    def get_associate_by_id(self, associate_id):
        sql = "SELECT * FROM associates where id=%s"
        records = DbConn.make_connect(sql, [associate_id])
        record = records[0]
        if record:
            return Associate(id=record[0], email=record[1], first_name=record[2], last_name=record[3], training_status="")
        else:
            f"User with id: {associate_id} - Not Found"

    def get_associate_in_batch(self, associate_id, batch_id):
        sql = "select a.id, a.first_name, a.last_name, a.email, ab.training_status " \
              "from associates as a left join associate_batches ab " \
              "on id = associate_id where associate_id = %s and batch_id = %s"
        records = DbConn.make_connect(sql, [associate_id, batch_id])
        record = records[0]
        if record:
            return Associate(id=record[0],  first_name=record[1], last_name=record[2], email=record[3],
                             training_status=record[4])
        else:
            f"User with id: {associate_id} - Not Found"



