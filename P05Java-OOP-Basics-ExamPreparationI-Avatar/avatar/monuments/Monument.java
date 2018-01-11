package avatar.monuments;

public abstract  class Monument {
    private String name;

    public Monument(String name) {
        this.name = name;
    }

    protected String getName() {
        return this.name;
    }

    public abstract int getPower();
}
