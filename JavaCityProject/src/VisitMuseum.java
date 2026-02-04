public class VisitMuseum extends CityActivity {
    private final CityActivity base;

    public VisitMuseum(CityActivity base) {
        this.base = base;
    }

    @Override
    public String getDescription() {
        return base.getDescription() + ", Visit the Main Museum";
    }

    @Override
    public double getCost() {
        return base.getCost() + 20;
    }

    @Override
    public double getTime() {
        return base.getTime() + 2.0;
    }
}
