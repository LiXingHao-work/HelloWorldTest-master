# HelloWorldTest

### function

#### login api
Default account is: test
,password is: 123456
#### HelloWorld api
Return users

#### achieve
#### login api
After submitting the account and password, 
LoginFilter will intercept the request, 
check if it is logged in, 
and then check if the password matches the 
encrypted password in the database,
and then JWT will generate a token , which will be added
to the response.
#### HelloWorld api
Retrieve the token from the request, chack 
it to verify if the password is correct, and 
then take users from the database
### Technologies

OpenJDK ^17  
springboot ^3.2.5  
spring-security  
JWT  
MySQL 8.1.0  

### Test Case
src.test.java.: mapper testing  
src.test.http: api testing  

姓名：李兴昊  
学校：东北林业大学  
学历：本科  
实习开始时间：六月初  
可持续时间：3个月到六个月  
可否在杭州办公：可以  
一句话概括你的优势：抗压能力强,可迅速适应环境,有较强学习意愿,学习能力较强  
期望从实习中收获什么：能熟悉企业真实的开发环境,了解工作内容,更重要的是想在实习结束后可以留在贵公司  
