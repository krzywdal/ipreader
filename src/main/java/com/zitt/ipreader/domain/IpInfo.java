package com.zitt.ipreader.domain;

/**
 *
 */
public class IpInfo {

    private String remoteAddr;
    private String userAgent;

    /**
     * @param remoteAddr
     * @param userAgent
     */
    public IpInfo(String remoteAddr, String userAgent) {
        this.remoteAddr = remoteAddr;
        this.userAgent = userAgent;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public String toString() {
        return "IpInfo{" +
                "remoteAddr='" + remoteAddr + '\'' +
                ", userAgent='" + userAgent + '\'' +
                '}';
    }
}
