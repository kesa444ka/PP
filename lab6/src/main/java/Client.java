class Client {
    private final ITarget target;

    public Client(ITarget target) {
        this.target = target;
    }

    public void show(double d, int i, char c) {
        target.ClientDouble(d);
        target.ClientInt(i);
        target.ClientChar(c);
    }
}