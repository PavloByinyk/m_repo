
package com.example.gottgried.mvvm_ac.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Issue {

    @SerializedName("assignee")
    private Object mAssignee;
    @SerializedName("assignees")
    private List<Object> mAssignees;
    @SerializedName("author_association")
    private String mAuthorAssociation;
    @SerializedName("body")
    private String mBody;
    @SerializedName("closed_at")
    private Object mClosedAt;
    @SerializedName("comments")
    private Long mComments;
    @SerializedName("comments_url")
    private String mCommentsUrl;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("events_url")
    private String mEventsUrl;
    @SerializedName("html_url")
    private String mHtmlUrl;
    @SerializedName("id")
    private Long mId;
    @SerializedName("labels")
    private List<Object> mLabels;
    @SerializedName("labels_url")
    private String mLabelsUrl;
    @SerializedName("locked")
    private Boolean mLocked;
    @SerializedName("milestone")
    private Object mMilestone;
    @SerializedName("node_id")
    private String mNodeId;
    @SerializedName("number")
    private Long mNumber;
    @SerializedName("repository_url")
    private String mRepositoryUrl;
    @SerializedName("state")
    private String mState;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("updated_at")
    private String mUpdatedAt;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("user")
    private User mUser;

    public Object getAssignee() {
        return mAssignee;
    }

    public void setAssignee(Object assignee) {
        mAssignee = assignee;
    }

    public List<Object> getAssignees() {
        return mAssignees;
    }

    public void setAssignees(List<Object> assignees) {
        mAssignees = assignees;
    }

    public String getAuthorAssociation() {
        return mAuthorAssociation;
    }

    public void setAuthorAssociation(String authorAssociation) {
        mAuthorAssociation = authorAssociation;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        mBody = body;
    }

    public Object getClosedAt() {
        return mClosedAt;
    }

    public void setClosedAt(Object closedAt) {
        mClosedAt = closedAt;
    }

    public Long getComments() {
        return mComments;
    }

    public void setComments(Long comments) {
        mComments = comments;
    }

    public String getCommentsUrl() {
        return mCommentsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        mCommentsUrl = commentsUrl;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getEventsUrl() {
        return mEventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        mEventsUrl = eventsUrl;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        mHtmlUrl = htmlUrl;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public List<Object> getLabels() {
        return mLabels;
    }

    public void setLabels(List<Object> labels) {
        mLabels = labels;
    }

    public String getLabelsUrl() {
        return mLabelsUrl;
    }

    public void setLabelsUrl(String labelsUrl) {
        mLabelsUrl = labelsUrl;
    }

    public Boolean getLocked() {
        return mLocked;
    }

    public void setLocked(Boolean locked) {
        mLocked = locked;
    }

    public Object getMilestone() {
        return mMilestone;
    }

    public void setMilestone(Object milestone) {
        mMilestone = milestone;
    }

    public String getNodeId() {
        return mNodeId;
    }

    public void setNodeId(String nodeId) {
        mNodeId = nodeId;
    }

    public Long getNumber() {
        return mNumber;
    }

    public void setNumber(Long number) {
        mNumber = number;
    }

    public String getRepositoryUrl() {
        return mRepositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        mRepositoryUrl = repositoryUrl;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

}
