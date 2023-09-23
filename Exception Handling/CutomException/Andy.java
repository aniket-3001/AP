public class Andy {
    private Wendy _wendy;

    public Andy(Wendy wendy) {
        _wendy = wendy;
    }

    public void drinkWater() {
        try {
            getWater();
        } catch (NoWaterException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getWater() throws NoWaterException {
        String _water = _wendy.getADrink();
        if (_water == null) {
            this.fire(_wendy);
            throw new NoWaterException("No Water");
        }
    }

    // Simulated fire method
    private void fire(Wendy wendy) {
        // Simulate firing Wendy
        System.out.println("Wendy has been fired!");
    }
}