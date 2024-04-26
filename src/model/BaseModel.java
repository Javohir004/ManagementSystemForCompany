package model;

import java.util.UUID;

public abstract class BaseModel {

    {
        this.id = UUID.randomUUID();
    }

    protected UUID id;
    protected boolean isActive = true;


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getActive() {
        return isActive;
    }

}
