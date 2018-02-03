package org.wolsnut4.models.jpa;

import org.wolsnut4.common.jpa.JpaModel;
import org.wolsnut4.models.UserModel;
import org.wolsnut4.models.jpa.entity.UserEntity;

import javax.persistence.EntityManager;
import java.util.Date;

public class UserAdapter implements UserModel, JpaModel<UserEntity> {

    private final EntityManager em;
    private final UserEntity user;

    public UserAdapter(EntityManager em, UserEntity user) {
        this.em = em;
        this.user = user;
    }

    public static UserEntity toEntity(UserModel model, EntityManager em) {
        if (model instanceof UserAdapter) {
            return ((UserAdapter) model).getEntity();
        }
        return em.getReference(UserEntity.class, model.getId());
    }

    @Override
    public UserEntity getEntity() {
        return user;
    }

    @Override
    public String getId() {
        return user.getId();
    }

    @Override
    public String getIdentityID() {
        return user.getIdentityID();
    }

    @Override
    public String getProviderType() {
        return user.getProviderType();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String getImageURL() {
        return user.getImageURL();
    }

    @Override
    public void setImageURL(String imageURL) {
        user.setImageURL(imageURL);
    }

    @Override
    public String getEmail() {
        return user.getEmail();
    }

    @Override
    public void setEmail(String email) {
        user.setEmail(email);
    }

    @Override
    public Date getCreatedAt() {
        return user.getCreatedAt();
    }

    @Override
    public Date getUpdatedAt() {
        return user.getUpdatedAt();
    }

    @Override
    public boolean isRegistrationCompleted() {
        return user.isRegistrationCompleted();
    }

    @Override
    public void setRegistrationCompleted(boolean registrationCompleted) {
        user.setRegistrationCompleted(registrationCompleted);
    }

    @Override
    public String getFullName() {
        return user.getFullName();
    }

    @Override
    public void setFullName(String fullName) {
        user.setFullName(fullName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserModel)) {
            return false;
        }
        UserModel other = (UserModel) obj;
        if (getId() != null) {
            if (!getId().equals(other.getId())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

}
