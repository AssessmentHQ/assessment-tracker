from daos.daos_impl.trainer_dao_impl import TrainerDAOImpl


class TrainerService:

    @classmethod
    def login(cls, email):
        return TrainerDAOImpl().login(email)