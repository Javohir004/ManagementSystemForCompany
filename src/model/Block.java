package model;

import java.util.UUID;

public class Block extends BaseModel {
    private UUID blocked;

    public Block(UUID blocked) {
        this.blocked = blocked;
    }

    public UUID getBlocked() {
        return blocked;
    }

    public void setBlocked(UUID blocked) {
        this.blocked = blocked;
    }
}
