class TrainerBatch:
    def __init__(self, trainer_id=0, batch_id=0, start_date="", end_date="", role=""):
        self.trainer_id = trainer_id
        self.batch_id = batch_id
        self.start_date = start_date
        self.end_date = end_date
        self.role = role

    def json(self):
        return {
            'trainerID': self.trainer_id,
            'batchId': self.batch_id,
            'startDate': self.start_date,
            'endDate': self.end_date,
            'role': self.role,
        }

    @staticmethod
    def json_parse(json):
        trainer_batch = TrainerBatch()
        trainer_batch.trainer_id = json["trainerID"]
        trainer_batch.batch_id = json["batchId"]
        trainer_batch.start_date = json["startDate"]
        trainer_batch.end_date = json["endDate"]
        trainer_batch.role = json["role"]
        return trainer_batch
