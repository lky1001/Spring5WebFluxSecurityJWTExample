# Spring5WebFluxSecurityOAuth2Example


## Get JWT Token
```
$ curl -X POST 'http://localhost:8081/auth' -H 'Content-Type: application/json' -d '{"username": "test", "password": "test"}'
{"token":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0Iiwicm9sZSI6WyJST0xFX1VTRVIiXSwiZW5hYmxlIjp0cnVlLCJleHAiOjE1NDE1NDY5NjEsImlhdCI6MTU0MTUxODE2MX0.jZ1l7GjBw1awlav7Wlx1qslAhwr94gD8ky9bfpCbUBuB6yz-QWNKJxJcinfEgplETiNx8zT3EF2gKKa8Skau7A"}
```

## Access Resource
```
$ curl -i 'http://localhost:8081/users/test' -H 'Content-Type: application/json' -H 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0Iiwicm9sZSI6WyJST0xFX1VTRVIiXSwiZW5hYmxlIjp0cnVlLCJleHAiOjE1NDE1NDY5NjEsImlhdCI6MTU0MTUxODE2MX0.jZ1l7GjBw1awlav7Wlx1qslAhwr94gD8ky9bfpCbUBuB6yz-QWNKJxJcinfEgplETiNx8zT3EF2gKKa8Skau7A'
HTTP/1.1 200 OK
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Content-Type-Options: nosniff
X-Frame-Options: DENY
X-XSS-Protection: 1 ; mode=block
Referrer-Policy: no-referrer
content-length: 0
```

## Your own user
- custom AuthHandler
