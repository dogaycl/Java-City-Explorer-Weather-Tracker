public class WalkInThePark extends CityActivity {
    private final CityActivity base;

    public WalkInThePark(CityActivity base) {
        this.base = base;
    }

    @Override
    public String getDescription() {
        return base.getDescription() + ", Walk in the Park";
    }

    @Override
    public double getCost() {
        return base.getCost() + 10;
    }

    @Override
    public double getTime() {
        return base.getTime() + 0.5;
    }
}
