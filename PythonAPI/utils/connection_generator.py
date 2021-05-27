
from configparser import ConfigParser


class ConnectionGenerator:

    @staticmethod
    def load_conn(database_file="../conn_cred.ini", section='postgresql'):
        # Checks if file exists and creates one if it does not
        infile = open(database_file, "a")
        infile.close()
        # create a parser
        parser = ConfigParser()
        # read config file
        parser.read(database_file)

        # get section, default to postgresql
        db = {}
        if parser.has_section(section):
            params = parser.items(section)
            for param in params:
                db[param[0]] = param[1]
        else:
            raise Exception('Section {0} not found in the {1} file'.format(section, database_file))

        return db


if __name__ == "__main__":
    ConnectionGenerator.load_conn("../conn_cred.ini")