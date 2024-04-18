package Repository;

import model.Block;

public class BlockRepositroy extends BaseRepository <Block> {

    public Integer addBlock(Block block) {
        if (check(block)) {
            return -1;
        }

        data.add(block);
        findById(block.getBlocked()).get().setActive(false);
        block.setActive(false);

        return 1;
    }

    public Integer unblockBlock(Block block){
        findById(block.getBlocked()).get().setActive(true);
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
