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


    @classmethod
    def get_trainers_in_batch(cls, batch_id):
        return cls.trainer_dao.get_trainers_in_batch(batch_id)

    @classmethod
    def get_years_for_trainer(cls, trainer_id):
        years = TrainerDAOImpl().get_years_for_trainer(trainer_id)
        years_dict = []
        for year in years:
            years_dict.append({"year": year})
        return years_dict
