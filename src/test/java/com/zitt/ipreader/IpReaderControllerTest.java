package com.zitt.ipreader;

import com.zitt.ipreader.controller.IpReaderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IpReaderControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private IpReaderController controller;

    private String host;

    @BeforeEach
    void setUp() {
        host = "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    void getIpInfo() {
        String result = this.restTemplate.getForObject(host + "/ipinfo", String.class);
        assertThat(result).contains("remoteAddr");
        assertThat(result).contains("userAgent");
    }
}