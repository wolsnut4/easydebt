package org.wolsnut4.common.jpa;

import java.util.Date;

public interface UpdatableEntity {
    void setUpdatedAt(final Date date);
}
