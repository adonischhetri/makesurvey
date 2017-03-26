# makesurvey
Installation steps:

1. Download and unextract the project folder.
2. Open STS and import the project as an existing Maven project.
3. Create a schema name 'coderovers' and database user with username and password 'root' both same.
4. Run application as Run on Server

Dummy Data:
===================
Survey creator: krishna - krishna
Survey taker: manish - manish
Admin: admin - admin


Create Survey Taker:
===================
1. Signup from home page(Survey Creator): default signup is Survey Creator
2. Then add new users(Survey Takers)

-------------------------------------------------------------

Take Survey
=================
1. Login using username and password provided by Survey creator(we are assuming email and link is sent to survey takers)
2. Click on email link (Like: http://localhost:8091/makesurvey/takesurvey?surveyId=1)
3. Fill the survey form and submit
(Test link: http://localhost:8091/makesurvey/takesurvey?surveyId=1)

Admin
=================
Future plan - List survey creators/takers, generate reports and more

