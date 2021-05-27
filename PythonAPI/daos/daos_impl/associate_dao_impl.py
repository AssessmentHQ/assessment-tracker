from daos.associate_dao import AssociateDAO
from models.associate import Associate
from utils.db_connection import DbConn


class AssociateDAOImpl(AssociateDAO):
    def get_associate_by_id(self, associate_id):
        sql = "SELECT * FROM associates where id=%s"
        records = DbConn.make_connect(sql, [associate_id])
        record = records[0]
        if record:
            return Associate(id=record[0], email=record[1], first_name=record[2], last_name=record[3], training_status=[])
        else:
            f"User with id: {associate_id} - Not Found"



