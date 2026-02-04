public class VisitCityCenter extends CityActivity {
    private final CityActivity base;

    public VisitCityCenter(CityActivity base) {
        this.base = base;
    }

    @Override
    public String getDescription() {
        return base.getDescription() + ", City Center Walk";
    }

    @Override
    public double getCost() {
        return base.getCost() + 15;
    }

    @Override
    public double getTime() {
        return base.getTime() + 1.5;
    }
}
