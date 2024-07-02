package com.exedy;

public class Feedback {
    private int feedbackId;
    private int productId;
    private int userId;
    private String userName;
    private String feedbackText;
    private String feedbackDate;

    public Feedback(int feedbackId, int productId, int userId, String userName, String feedbackText, String feedbackDate) {
        this.feedbackId = feedbackId;
        this.productId = productId;
        this.userId = userId;
        this.userName = userName;
        this.feedbackText = feedbackText;
        this.feedbackDate = feedbackDate;
    }

    public Feedback(int productId, int userId, String userName, String feedbackText) {
        this.productId = productId;
        this.userId = userId;
        this.userName = userName;
        this.feedbackText = feedbackText;
    }

    // Add getters and setters for the fields

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public String getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(String feedbackDate) {
        this.feedbackDate = feedbackDate;
    }
}
