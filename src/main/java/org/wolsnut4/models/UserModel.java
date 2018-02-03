package org.wolsnut4.models;

import java.util.Date;

public interface UserModel {

    String USERNAME = "username";
    String FULL_NAME = "fullName";

    String getId();

    String getIdentityID();

    String getProviderType();

    String getUsername();

    String getFullName();

    void setFullName(String fullName);

    boolean isRegistrationCompleted();

    void setRegistrationCompleted(boolean registrationCompleted);

    String getImageURL();

    void setImageURL(String imageURL);

    String getEmail();

    void setEmail(String email);

    Date getCreatedAt();

    Date getUpdatedAt();
}
