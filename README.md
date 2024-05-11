# Whatsapp Interactive ChatBoot
Use this code base to implement a Whatsapp chatboot.  
You need a business account on CM.com: it will provide you a phone number and a KEY. Set up them in *productToken* and *from*.  

Run with maven  
### Example of API call
POST on localhost:8080/conversation  
```
{"reference": "wamid.HBgLMzM2MzM1NjI2MDYVAgASGBYzRUIwNEVDQjNCNDQ2", "messageContext": "", "from": {"number": "+33999999999", "name": "Mary"}, "to": {"number": "0033666666666"}, "message": {"text": "hello", "media": {"mediaUri": "", "contentType": "", "title": ""}, "custom": {"meta_received_time": "2024-05-06T11:37:48", "message_type": "text"}, "error": ""}, "groupings": ["", "", ""], "time": "2024-05-06 13:37:49", "timeUtc": "2024-05-06T11:37:49", "channel": "WhatsApp"}
```