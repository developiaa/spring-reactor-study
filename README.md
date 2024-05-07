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
