package Game.Entity;


public class Item {
    public enum ItemType {
        KEY, SHOCK_TRAP
    }

    private ItemType itemType;

    public Item(ItemType itemType) {
        this.itemType = itemType;
    }

    private boolean door;

    public ItemType getItemType() {
        return itemType;
    }

    public void use(Player player) {
        switch (itemType) {
            case KEY:
                pickKey(player);
                break;
            case SHOCK_TRAP:
                useShockTrap(player);
                break;
        }
    }

    public void hasKey(){
        boolean unlock = true;
    }
    private void pickKey(Player player) {
   /*    if(door.islocked()){
            if(null != hasKey()){
                door.unlock();
                openDoor();
            }
        }
    */
    }

    private void useShockTrap(Player player) {
            // implent the logic when place trap
    }

}

