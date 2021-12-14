package com.zitt.ipreader;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@RestController
public class IpReaderController {

    private static Logger LOG = Logger.getLogger("IpReaderController.class");

    private static final String[] IP_HEADER_CANDIDATES = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR"};

    @GetMapping("/ipinfo")
    public IpInfo getIpInfo(HttpServletRequest request) {
        IpInfo response = null;

        for (String header : IP_HEADER_CANDIDATES) {
            String ip = request.getHeader(header);
            if (ip != null && ip.length() != 0
                    && !"unknown".equalsIgnoreCase(ip)) {
                response = new IpInfo(ip, request.getHeader(HttpHeaders.USER_AGENT));
                break;
            }
        }
        if (response == null) {
            response = new IpInfo(request.getRemoteAddr(), request.getHeader(HttpHeaders.USER_AGENT));
        }

        LOG.info("Handle request returning: " + response);

        return response;
    }


}
