package Repository;

import model.Block;

public class BlockRepositroy extends BaseRepository <Block> {

    public Integer addBlock(Block block) {
        if (check(block)) {
            return -1;
        }
        /// block.setId(UUID.randomUUID());
        data.add(block);
        block.setActive(false);

        return 1;
    }

    public boolean check(Block block) {
        for (Block block1 : data) {
            if (block1.getId().equals(block.getId())) {
                return true;
            }
        }
        return false;
    }

    
}
