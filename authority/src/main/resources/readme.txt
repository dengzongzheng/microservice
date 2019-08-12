curl -X POST --user 'policy:123456' -d 'grant_type=password&username=18511898011&password=1000&type=phone&smsCode=1000' http://localhost:9001/oauth/token

curl -X POST --user 'policy:123456' -d 'grant_type=refresh_token&refresh_token=07189924-b188-4212-a136-4ff71e7a4b4b' http://localhost:8002/oauth/token