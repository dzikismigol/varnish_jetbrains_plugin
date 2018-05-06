probe healthcheck {
    .interval = 5s;
    .timeout = 3s;
    .window = 5;
    .threshold = 3;
    .request =
        "GET / HTTP/1.1"
        "Host: some-service.prod"
        "Connection: close"
        "User-Agent: varnish-probe";
}
