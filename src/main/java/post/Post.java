package post;

import com.google.gson.annotations.Expose;
import user.User;

import java.util.List;
import java.util.Objects;

public class Post {

    private String title;
    private String description;
    private String body;
    private String imageUrl;
    @Expose(serialize = true, deserialize = false)
    private String publishDate;
    @Expose(serialize = false, deserialize = true)
    private boolean draft;
    @Expose(serialize = true, deserialize = false)
    private String id;
    @Expose(serialize = true, deserialize = false)
    private String userId;
    private String updatedAt;
    private User user;

    public Post() {
    }

    public Post(String title, String description, String body, String imageUrl, boolean draft) {
        this.title = title;
        this.description = description;
        this.body = body;
        this.imageUrl = imageUrl;
        this.draft = draft;
    }

    public Post(String title, String description, String body, String imageUrl, String publishDate, boolean draft) {
        this.title = title;
        this.description = description;
        this.body = body;
        this.imageUrl = imageUrl;
        this.publishDate = publishDate;
        this.draft = draft;
    }

    public Post(String title, String description, String body, String imageUrl, String publishDate, boolean draft, String id, String userId, String updatedAt) {
        this.title = title;
        this.description = description;
        this.body = body;
        this.imageUrl = imageUrl;
        this.publishDate = publishDate;
        this.draft = draft;
        this.id = id;
        this.userId = userId;
        this.updatedAt = updatedAt;
    }

    public Post(String title, String description, String body, String imageUrl, String publishDate, boolean draft, String id, String userId, String updatedAt, User user) {
        this.title = title;
        this.description = description;
        this.body = body;
        this.imageUrl = imageUrl;
        this.publishDate = publishDate;
        this.draft = draft;
        this.id = id;
        this.userId = userId;
        this.updatedAt = updatedAt;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public boolean isDraft() {
        return draft;
    }

    public boolean getDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return draft == post.draft && title.equals(post.title) && description.equals(post.description) && body.equals(post.body) && imageUrl.equals(post.imageUrl) && publishDate.equals(post.publishDate) && id.equals(post.id) && userId.equals(post.userId) && updatedAt.equals(post.updatedAt) && user.equals(post.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, body, imageUrl, publishDate, draft, id, userId, updatedAt, user);
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", body='" + body + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", draft=" + draft +
                ", id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", user=" + user +
                '}';
    }
}
