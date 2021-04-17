## spring-boot-aspect-annotation-log-method-in-out-parameters

1- Log to the console execution time for a restController method annotated with LogMethodExecutionTime from @Around advice.<br/>

### Tech Stack
Java 11 <br/>
H2 Database Engine <br/>
spring boot <br/>
spring data jpa <br/>
spring web <br/>
spring aspects <br/>
hibernate <br/>
logback <br/>
maven <br/>
junit <br/>
<br/>

## API OPERATIONS
### Save customer sucessfully to database

Method : HTTP.POST <br/>
URL : http://localhost:8080/customer/save <br/>

Request : 
<pre>
{ 
  "name":"name1",
  "age":1,
  "addresses":[
                {"streetName":"software","city":"ankara","country":"TR"}
              ]
}
</pre><br/>

Response : 

HTTP response code 200 <br/>
<pre>
{
    "id": 1,
    "name": "name1",
    "age": 1,
    "addresses": [
        {
            "id": 1,
            "streetName": "software",
            "city": "ankara",
            "country": "TR"
        }
    ]
}
</pre><br/>

<pre>
Console log message :

com.company.customerinfo.config.aspect.LoggingAspect: -------------------------------
com.company.customerinfo.config.aspect.LoggingAspect: Start Log for @Around advice execution for LogMethodExecutionTime annotation
com.company.customerinfo.config.aspect.LoggingAspect: Total time for method execution com.company.customerinfo.controller.CustomerController.save took --> 184 ms
com.company.customerinfo.config.aspect.LoggingAspect: Method Input Parameters : {customer=Customer{id=1, name='name1', age=1, addresses=[Address{id=1, streetName='software', city='ankara', country='TR'}]}}
com.company.customerinfo.config.aspect.LoggingAspect: Method Output Parameters : <200 OK OK,Customer{id=1, name='name1', age=1, addresses=[Address{id=1, streetName='software', city='ankara', country='TR'}]},[]>
com.company.customerinfo.config.aspect.LoggingAspect: End Log for @Around advice execution for LogMethodExecutionTime annotation
com.company.customerinfo.config.aspect.LoggingAspect: -------------------------------
</pre><br/>
