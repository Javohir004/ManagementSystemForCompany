package service;

import Repository.BlockRepositroy;
import model.Block;

public class BlockService extends BaseService <Block , BlockRepositroy> {
    public BlockService(BlockRepositroy repository) {
        super(repository);
    }

    @Override
    public Block mapNullFields(Block original, Block update) {
        return null;
    }

    @Override
    public boolean check(Block block) {
        return false;
    }
}
