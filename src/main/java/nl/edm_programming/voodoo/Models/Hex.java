package nl.edm_programming.voodoo.Models;

import java.util.UUID;

public class Hex {

    public Hex(java.util.UUID UUID) {
        this.UUID = UUID;
    }

    private UUID UUID;
    private boolean Warded;

    public java.util.UUID getUUID() {
        return UUID;
    }

    public void setUUID(java.util.UUID UUID) {
        this.UUID = UUID;
    }

    public boolean isWarded() {
        return Warded;
    }

    public void setWarded(boolean warded) {
        Warded = warded;
    }
}
