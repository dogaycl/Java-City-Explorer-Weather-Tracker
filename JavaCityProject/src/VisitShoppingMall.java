public class VisitShoppingMall extends CityActivity {
    private final CityActivity base;

    public VisitShoppingMall(CityActivity base) {
        this.base = base;
    }

    @Override
    public String getDescription() {
        return base.getDescription() + ", Shopping Mall";
    }

    @Override
    public double getCost() {
        return base.getCost() + 30;
    }

    @Override
    public double getTime() {
        return base.getTime() + 2.5;
    }
}
