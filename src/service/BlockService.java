package service;

import repository.BlockRepositroy;
import model.Block;

public class BlockService extends BaseService <Block , BlockRepositroy> {
    public BlockService(BlockRepositroy repository) {
        super(repository);
    }

    @Override
    public boolean check(Block block) {
        return block.getActive();
    }

    public Integer block(Block block){
      return repository.addBlock(block);
    }

    public Integer unblock(Block block){
        return  repository.unblockBlocked(block);
    }


}
