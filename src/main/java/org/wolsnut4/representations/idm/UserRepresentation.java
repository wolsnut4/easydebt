package org.wolsnut4.representations.idm;

import java.util.Date;

public class UserRepresentation {

    private Data data;

    public UserRepresentation() {
    }

    public UserRepresentation(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private String id;
        private String type;
        private UserAttributesRepresentation attributes;
        private GenericLinksRepresentation links;

        public UserRepresentation toUserRepresentation() {
            return new UserRepresentation(this);
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public UserAttributesRepresentation getAttributes() {
            return attributes;
        }

        public void setAttributes(UserAttributesRepresentation attributes) {
            this.attributes = attributes;
        }

        public GenericLinksRepresentation getLinks() {
            return links;
        }

        public void setLinks(GenericLinksRepresentation links) {
            this.links = links;
        }
    }

    public static class UserAttributesRepresentation {
        private String userID;

        private String identityID;
        private String providerType;

        private String email;
        private String username;
        private String fullName;
        private String imageURL;
        private Boolean registrationCompleted;

        private Date createdAt;
        private Date updatedAt;

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public String getIdentityID() {
            return identityID;
        }

        public void setIdentityID(String identityID) {
            this.identityID = identityID;
        }

        public String getProviderType() {
            return providerType;
        }

        public void setProviderType(String providerType) {
            this.providerType = providerType;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getImageURL() {
            return imageURL;
        }

        public void setImageURL(String imageURL) {
            this.imageURL = imageURL;
        }

        public Boolean getRegistrationCompleted() {
            return registrationCompleted;
        }

        public void setRegistrationCompleted(Boolean registrationCompleted) {
            this.registrationCompleted = registrationCompleted;
        }

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        public Date getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
}
