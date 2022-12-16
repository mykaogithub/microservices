# microservices
Repository for microservices demo projects
Introduction to Currency Conversion and Currency Exchange Service
In this section, we will create a couple of microservices: CurrencyCalculationService and CurrencyExchangeService.

Introduction to Currency Conversion and Currency Exchange Service
Note: In this tutorial, we have quoted currency conversion service as a currency calculation service. Both the services have the same meaning, so don't be confused.
Let's understand the functionality of these services.

In the above figure, the CurrencyExchangeService uses JPA to talk to the database and returns the exchange value of the specific currency. For example, USD to INR conversion.

When we invoke CurrencyExchangeService, we need to pass two parameters: from(convert from), and to (convert to). For example, if we want to convert currency from USD to INR.
Play Videox

Consider the URL http://localhost:8000/currency-exchange/from/USD/to/INR. It retunes the following response:

{  
id: 101,  
from: "USD",  
to: "INR",  
conversionMultiple: 72,  
port: 8000  
}  
The currency exchange service will return what the conversion multiple is. The conversion multiple means 1 USD is equal to 72 INR. The currency converter service uses a currency exchange service. Suppose the currency converter service wants to convert 100 USD to INR. So it will call the currency exchange service and will convert the specified amount that we have provided in the path parameter. For example:

http://localhost:8100/currency-converter/from/USD/to/INR/quantity/100

{  
Id: 101,  
from: "USD",  
to: "INR",  
conversionMultiple: 72,  
quantity: 100  
totalCalculatedAmount: 7200,  
port: 8000  
}  
We will implement these two services in our example using Spring Cloud.

Setting up a currency-exchange-service
