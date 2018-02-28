# SpringBootMailWithActiveMq


This is a sample mail rest api project which uses spring boot and activemq.
You can change mail smtp configurations from application.yml file.


# Test

You can post the sample json request to the url: http://localhost:8080/mail

    {
	     "sender": "obacoin@yandex.com",
	      "replyTo": "enes.acikoglu@gmail.com",
	      "toList": ["enes.acikoglu@gmail.com", "enes.acikogluu@gmail.com", "obacoin@yandex.com"],
	      "subject": "ActiveMq Mail with Spring Boot",
	      "body": "<html><head><title>Spring Boot with ActiveMQ</title></head><body><h1>Spring Boot adamdır!</h1><p>Active Mq sekil onumden cekil</p></body></html>"
    }        
