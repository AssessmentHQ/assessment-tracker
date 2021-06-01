import psycopg2
from psycopg2 import Error

from utils.connection_generator import ConnectionGenerator


class DbConn:

    @staticmethod
    def make_connect(query = None, values = None):
        """Connects to the database and executes a query, returns a list of records"""
        connection = None
        cursor = connection
        try:
            # read connection parameters
            params = ConnectionGenerator.load_conn()
            # Connect to an existing database
            connection = psycopg2.connect(**params)
            # If you don't specify a query into this function then default to this
            if query is None:
                # Create a cursor to perform database operations
                cursor = connection.cursor()

                # Executing a SQL query
                cursor.execute("SELECT version();", "make_connect")
                # Fetch result
                record = cursor.fetchall()
                return record
            else:
                # Create a cursor to perform database operations
                cursor = connection.cursor()
                # Executing a SQL query
                cursor.execute(query, values)
                # Commit the SQL query
                connection.commit()
                # Fetch result
                record = cursor.fetchall()

                return record

        except (Exception, Error) as error:
            raise error
        finally:
            if connection:
                cursor.close()
                connection.close()


if __name__ == "__main__":
    DbConn.make_connect()
