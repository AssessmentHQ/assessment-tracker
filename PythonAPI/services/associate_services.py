from daos.daos_impl.associate_dao_impl import AssociateDAOImpl


class AssociateServices:
    associate_dao = AssociateDAOImpl()

    @classmethod
    def get_associated_byID(cls, associate_id):
        return cls.associate_dao.get_associate_by_id(associate_id)

    @classmethod
    def get_associate_in_batch(cls, associate_id, batch_id):
        return cls.associate_dao.get_associate_in_batch(batch_id, associate_id)
