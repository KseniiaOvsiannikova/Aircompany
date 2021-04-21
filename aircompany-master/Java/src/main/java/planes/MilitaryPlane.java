package planes;

import models.MilitaryTypes;

import java.util.Objects;

public class MilitaryPlane extends Plane{

    private MilitaryTypes type;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryTypes type) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
    }

    public MilitaryTypes getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + type +
                '}');
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!super.equals(object)) return false;
        MilitaryPlane that = (MilitaryPlane) object;

        return type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }
}
