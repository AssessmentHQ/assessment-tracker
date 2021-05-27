import datetime

from psycopg2._psycopg import connection

from daos.batch_dao import BatchDAO
from models.batch_model import Batch


class BatchDAOImpl(BatchDAO):
    @classmethod
    def get_all_batches_by_year(self, year):
        sql = "SELECT * FROM batches WHERE start_date = %s"
        cursor = connection.cursor()
        cursor.execute(sql, [year])
        record = cursor.fetchone()
        print(record[0])
        if record:
            return Batch(record[0], record[1], record[2], record[3], record[4])
        else:
            return f"Batch with {year} - Not Found", 404


    @classmethod
    def add_batch(cls, batch_id):
        try:
            batches = BatchDAO.get_all_batches_by_year(batch_id)
            batch_list = []
            for batch in batches:
                batch_list.append((batch.id, batch.name, batch.training_track, batch.start_date, batch.end_date))
            sql = "INSERT INTO batches values(default, %s, %s, %s, %s) RETURNING *"
            cursor = connection.cursor()
            cursor.executemany(sql, batch_list)
            connection.commit()

            # ProductCartDAO.delete_cart_items_from_user_id(user_id)

            return "New Batch Added", 200
        except Exception as e:
            return "Batch does not exist. Please try again.", 404

