package com.zitt.ipreader;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IpReaderController {

    @GetMapping("/ipinfo")
    public IpInfo getIpInfo(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        return new IpInfo(remoteAddr);
    }
}
