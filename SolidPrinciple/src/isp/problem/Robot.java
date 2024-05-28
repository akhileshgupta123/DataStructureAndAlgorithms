package isp.problem;

public class Robot implements Worker{
    @Override
    public void work() {
        System.out.println("Robot working");
    }

    @Override
    public void eat() {
        // Robots don't eat
        throw new UnsupportedOperationException("Robots don't eat");
    }
}
