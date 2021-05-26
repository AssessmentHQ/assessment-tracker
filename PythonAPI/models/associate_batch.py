class AssociateBatch:
    def __init__(self, associate_id=-1, batch_id=0, start_date="", end_date="", training_status=""):
        self.associate_id = associate_id
        self.batch_id = batch_id
        self.start_date = start_date
        self.end_date = end_date
        self.training_status = training_status

    def json(self):
        return {
            'associateID': self.associate_id,
            'batchID': self.batch_id,
            'startDate': self.start_date,
            'endDate': self.end_date,
            'trainingStatus': self.training_status
        }

    @staticmethod
    def json_parse(json):
        associate_batch = AssociateBatch()
        associate_batch.associate_id = json["associateID"]
        associate_batch.batch_id = json["batchID"]
        associate_batch.start_date = json["startDate"]
        associate_batch.end_date = json["endDate"]
        associate_batch.training_status = json["trainingStatus"]
        return associate_batch
