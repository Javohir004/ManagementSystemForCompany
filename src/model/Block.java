package model;

import java.util.UUID;

public class Block extends BaseModel {
    private UUID blockId;

    public Block(UUID blockId) {
        this.blockId = blockId;
    }

    public UUID getBlockId() {
        return blockId;
    }

    public void setBlockId(UUID blockId) {
        this.blockId = blockId;
    }
}
