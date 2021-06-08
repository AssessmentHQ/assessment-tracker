# Assessment Tracker Application Startup

## Create an Instance of EC2

The frontend of this application looks for an app running on an instance of Amazon EC2. Make sure you have access to an instance of an EC2, and free tier will suffice.

## Set Up an RDS

We used Amazon RDS with PostgreSQL to store data. The files to set up the tables in the database and to insert data are contained in the [Database](https://github.com/AssessmentHQ/assessment-tracker/tree/main/Database) folder of the repository. Included are diagrams of the ERD as it should display after running the "create" scripts.

## Configure Jenkins

To build the project through Jenkins, simply go to the Configure tab on an empty project and enter the GitHub link in 2 fields: first, click the check box "GitHub Project" in the general tab and input the url. Second, in the "Source Management" tab, click on "Git" and input the repository url, as well as any needed credentials and the desired branch to build from. Stay in the Configure menu for the next step.

## Input the Jenkins Command Script

In the Configure menu, click the "Build" tab, and click Add a Build Step -> Execute Shell. Then, copy and paste [this code](#jenkins-command-script) into the text area that shows up. Make sure to fill in your RDS credential information in the section headed "Add data to connection file." This script will automatically create a root folder, install any necessary dependencies, creates necessary files so the application can run, and launches the APIs. Then, click "Apply" and "Save", and make sure to Build the project. Anytime a change is made, the project will need to be rebuilt.

## Access the Website

After building the project, access the frontend by navigating to the HTML files in the [PythonAPi/templates](https://github.com/AssessmentHQ/assessment-tracker/tree/main/PythonAPI/templates) folder of this repository. Access the home.html file to open the home page in your browser.

## Jenkins Command Script

```jenkins
#Navigate to the project folder
cd /root/.jenkins/workspace/AssessmentTracker

# kill flask app if there is one running
[[ ! -z "$(sudo lsof -t -i:5000)" ]] && kill $(sudo lsof -t -i:5000) || echo "Not Started"

# install/upgrade pip
sudo yum install python3-pip -y

#install dependencies
pip3 install -r PythonAPI/requirements.txt

#create connection file
touch conn_cred.ini

#Add data to connection file 
echo "[postgresql]
host= <DATABASEHOST>
database=postgres
user=<USERNAME>
password=<PASSWORD>
port=5432" > conn_cred.ini

# workaround to insure app doesn’t get killed
export BUILD_ID=dontKillMe

# run Python app
python3 PythonAPI/app.py &

#Navigate to Java project
cd /root/.jenkins/workspace/AssessmentTracker/JavaAPI

# kill Javelin app if there is one running
[[ ! -z "$(sudo lsof -t -i:7001)" ]] && kill $(sudo lsof -t -i:7001) || echo "Not Started"

#Create properties file for database connection
touch resources/connection.properties

#Add RDS credentials to properties file
echo "url=jdbc:postgresql://<DATABASEHOST>/<DATABASENAME>
     username=<USERNAME>
     password=<PASSWORD>" > resources/connection.properties

#clean the project
mvn clean

#Package the project
mvn package

#Run the Java API
java -jar target/com.revature.assessments.jar &
```
