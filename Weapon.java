package ro.uvt.p3.lab7;

public class Weapon extends Item implements Equipment {
    int minAttack;
    int maxAttack;

    public Weapon(String name, int minAttack, int maxAttack){
        super(name);
        this.minAttack = minAttack;
        this.maxAttack = maxAttack;
    }

    public int getMinAttack() {
        return minAttack;
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    public MountPoint getMountPoint() {
        return MountPoint.ATTACK_ARM;
    }
}
