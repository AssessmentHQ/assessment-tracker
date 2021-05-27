import datetime

from psycopg2._psycopg import connection

from daos.batch_dao import BatchDAO
from models.batch_model import Batch
from utils.db_connection import DbConn


class BatchDAOImpl(BatchDAO):
    def get_all_batches_by_year(self, year):

        sql = "SELECT * FROM batches WHERE date_part('year', batches.start_date) = %s "
        record = DbConn.make_connect(sql, [year])
        batches = []
        for batch in record:
            batches.append(Batch(batch[0], batch[1], batch[2], batch[3], batch[4]))
        return batches



