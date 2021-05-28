from daos.daos_impl.trainer_dao_impl import TrainerDAOImpl


class TrainerService:


    @classmethod
    def login(cls, email):
        return TrainerDAOImpl().login(email)

    trainer_dao = TrainerDAOImpl()
    @classmethod
    def login(cls, email):
        return TrainerDAOImpl().login(email)

    @classmethod
    def get_trainer_byID(cls, trainer_id):
        return cls.trainer_dao.get_trainer_by_id(trainer_id)

