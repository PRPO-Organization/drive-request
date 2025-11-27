package com.skupina1.model;

import java.time.LocalDateTime;

public class Notification {
    private int id;
    private String recipient;
    private String subject;
    private String body;
    private LocalDateTime createdAt;

    public Notification() {}

    public Notification(String recipient, String subject, String body) {
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
        this.createdAt = LocalDateTime.now();
    }

    public int getId() {return this.id;}
    public String getRecipient() {return this.recipient;}
    public String getBody() {return this.body;}
    public String getSubject() {return this.subject;}
    public LocalDateTime getCreatedAt() {return this.createdAt;}

    public void setRecipient(String recipient) {this.recipient = recipient;}
    public void setSubject(String subject) {this.subject = subject;}
    public void setBody(String body) {this.body = body;}
    public void setId(int id) {this.id = id;}
    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}

    public static String requestEmailBody(long reqId, long driverId) {
        return "<html>\n" +
                "<body>\n" +
                "    <p>You have a new ride request!</p>\n" +
                "\n" +
                "    <a href=\"https://your-drive-request-domain.com/v1/driver/response/confirm" +
                "?requestId=" + reqId +
                "&driverId=" + driverId + "\"" +
                "       style=\"padding: 12px 20px; background-color: #4CAF50; color: white; text-decoration: none; border-radius: 6px;\">\n" +
                "       Accept Ride\n" +
                "    </a>\n" +
                "    <a href=\"https://your-drive-request-domain.com/v1/driver/response/confirm" +
                "?requestId=" + reqId +
                "&driverId=" + driverId +
                "&accepted=false\"" +
                "       style=\"padding: 12px 20px; background-color: #d9534f; color: white; text-decoration: none; border-radius: 6px;\">\n" +
                "       Decline Ride\n" +
                "    </a>\n" +
                "</body>\n" +
                "</html>";
    }
}
