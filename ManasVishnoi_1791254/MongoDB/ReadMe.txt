///////////////////////////////////////////////////////////////////////////
BEFORE YOU GO FORWARD PLEASE NOTE THE FOLLOWING:

1.H2-DATABASE JPA is associated with service named : User

It will have all the files of controller,service,repository,serviceImpl and userModel.

PATH:TCS MS-GRP-5\ManasVishnoi_1791254\JPA\UserService\src\main\java\com\example\MyWeb\UserService\UserModel

flow of program is this:
controller---> service--->serviceImpl (this is where repository work is autowired)---> Repository(now this uses getter and setters to do opreation in database)------> Model(contains getter,setter,contructor and variables).

2. Mongo-Database is associated with the service name :Stocks

PATH:C:TCS MS-GRP-5\ManasVishnoi_1791254\MongoDB\UserService\src\main\java\com\example\MyWeb\UserService\Stocks

flow of program is same as JPA.

3. I have made Exception Handling seperately which mean it has a global exception handling and some UserCase exceptions which may occur during usage.



///////////////////////////////////////////////////////////////////////