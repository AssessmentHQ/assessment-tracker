
from daos.batch_dao import BatchDAO
from models.batch import Batch
from utils.db_connection import DbConn


class BatchDAOImpl(BatchDAO):
    def get_all_batches_by_year(self, year):

        sql = "SELECT * FROM batches WHERE date_part('year', batches.start_date) = %s "
        record = DbConn.make_connect(sql, [year])
        batches = []
        for batch in record:
            batches.append(Batch(id=batch[0], start_date=batch[1], end_date=batch[2], name=batch[3], training_track=batch[4]))
        return batches



