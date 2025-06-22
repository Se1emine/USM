// Клас Point представляет точку на плоскости
class Point {
    private double x;
    private double y;

    public Point() {
        this(0, 0);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("Point(x=%.2f, y=%.2f)", x, y);
    }
}

// Клас RoundPlate наследует Point и добавляет радиус
class RoundPlate extends Point {
    private double radius;

    public RoundPlate(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return String.format("RoundPlate(center=%s, radius=%.2f, area=%.2f)",
                super.toString(), radius, getArea());
    }
}

// Клас CylindricalGlass наследует RoundPlate и добавляет высоту и метод для объема
class CylindricalGlass extends RoundPlate {
    private double height;

    public CylindricalGlass(double x, double y, double radius, double height) {
        super(x, y, radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return getArea() * height;
    }

    /**
     * Проверяет, входит ли этот стеклянный цилиндр в другой.
     * Условие: радиус <= радиуса другого и высота <= высоты другого.
     */
    public boolean fitsIn(CylindricalGlass other) {
        return this.getRadius() <= other.getRadius() && this.height <= other.height;
    }

    @Override
    public String toString() {
        return String.format("CylindricalGlass(center=%s, radius=%.2f, height=%.2f, volume=%.2f)",
                super.toString().substring(12, super.toString().length() - 1), // убрать префикс RoundPlate
                getRadius(), height, getVolume());
    }
}

public class Main {
    public static void main(String[] args) {
        CylindricalGlass glass1 = new CylindricalGlass(0, 0, 3, 10);
        CylindricalGlass glass2 = new CylindricalGlass(1, 1, 4, 8);

        System.out.println("Характеристики стакана 1: \n" + glass1);
        System.out.println("Характеристики стакана 2: \n" + glass2);

        if (glass1.getVolume() > glass2.getVolume()) {
            System.out.println("Стакан 1 больше стакана 2 по объему.");
        } else if (glass1.getVolume() < glass2.getVolume()) {
            System.out.println("Стакан 2 больше стакана 1 по объему.");
        } else {
            System.out.println("Оба стакана имеют одинаковый объем.");
        }

        if (glass1.fitsIn(glass2)) {
            System.out.println("Стакан 1 входит в стакан 2.");
        } else if (glass2.fitsIn(glass1)) {
            System.out.println("Стакан 2 входит в стакан 1.");
        } else {
            System.out.println("Ни один из стаканов не входит в другой.");
        }
    }
}
