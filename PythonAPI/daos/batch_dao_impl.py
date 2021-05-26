from psycopg2._psycopg import connection

from daos.batch_dao import BatchDAO
from models.batch_model import Batch


class BatchDAOImpl(BatchDAO):
    @classmethod
    def get_all_batches(self):
        try:
            sql = "SELECT * FROM batches"
            cursor = connection.cursor()
            cursor.execute(sql)
            records = cursor.fetchall()
            batches = []
            for batch in records:
                batches.append(Batch(batch[0], batch[1], batch[2], batch[3], batch[4]))
            return batches
        except Exception as e:
            return None

    @classmethod
    def add_batch(cls, batch_id):
        try:
            # order_num = cls.return_largest_order_number()
            batches = BatchDAO.get_all_batches(batch_id)
            batch_list = []
            for batch in batches:
                batch_list.append((batch.id, batch.name, batch.training_track,batch.start_date, batch.end_date))
            sql = "INSERT INTO batches values(default, %s, %s, %s, %s) RETURNING *"
            cursor = connection.cursor()
            cursor.executemany(sql, batch_list)
            connection.commit()

            # ProductCartDAO.delete_cart_items_from_user_id(user_id)

            return "New Batch Added", 200
        except Exception as e:
            return "Batch does not exist. Please try again.", 404

