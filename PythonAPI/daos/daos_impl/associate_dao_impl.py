from daos.associate_dao import AssociateDAO
from exceptions.resource_not_found import ResourceNotFound
from models.associate import Associate
from utils.db_connection import DbConn


class AssociateDAOImpl(AssociateDAO):
    def get_associate_by_id(self, associate_id):
        """Get a specific Associate by their ID"""
        sql = "SELECT * FROM associates where id=%s"
        records = DbConn.make_connect(sql, [associate_id])
        if records:
            # only get the first record returned
            record = records[0]
            return Associate(id=record[0], email=record[1], first_name=record[2], last_name=record[3], training_status="")
        else:
            raise ResourceNotFound("No associate found with that id")

    def get_associate_in_batch(self, associate_id, batch_id):
        """Get an  Associate in a batch by  their ID and a batch ID"""
        sql = "select a.id, a.first_name, a.last_name, a.email, ab.training_status " \
              "from associates as a left join associate_batches ab " \
              "on id = associate_id where associate_id = %s and batch_id = %s"
        records = DbConn.make_connect(sql, [associate_id, batch_id])
        if records:
            record = records[0]
            return Associate(id=record[0],  first_name=record[1], last_name=record[2], email=record[3],
                             training_status=record[4])
        else:
            raise ResourceNotFound("No associate could be found with that id and/or batch")

    def get_all_associates_in_batch(self, batch_id):
        """Get an all Associates in a batch by a batch ID"""
        sql = "select a.id, a.first_name, a.last_name, a.email, ab.training_status " \
              "from associates as a left join associate_batches ab " \
              "on id = associate_id where batch_id = %s"
        records = DbConn.make_connect(sql, [batch_id])
        associates = []
        if records:
            for anAssociate in records:
                associates.append(
                    Associate(id=anAssociate[0], first_name=anAssociate[1], last_name=anAssociate[2], email=anAssociate[3],
                              training_status=anAssociate[4]))
            return associates
        else:
            raise ResourceNotFound("No batch could be found with that id")



