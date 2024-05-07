# redis 명령어 확인 shellscript
```shell
while [ true ];
do date;
redis-cli zcard users:queue:default:wait;
redis-cli zcard users:queue:default:proceed;
sleep 1;
done;
```

# Error
An exception has been observed post termination, use DEBUG level to see the full stack: java.net.SocketException: Connection reset


# website
http://127.0.0.1:9000/?user_id=22


# api
http://127.0.0.1:9010/waiting-room?user_id=44&redirect_url=http://127.0.0.1:9000?user_id=44
