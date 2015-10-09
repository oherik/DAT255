package com.alive_n_clickin.commutity.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * A class containing the same variables as a vehicle, in addition to a variable showing when it
 * will arrive to a specified stop. It also contains the flags for that vehicle.
 */
@EqualsAndHashCode(callSuper = true)
@ToString
public class ArrivingVehicle extends AbstractVehicle implements IArrivingVehicle{
    private final Date arrivalTime;
    private final List<IFlag> flags;

    /**
     * Constructor.
     * @param destination Where the vehicle is headed, e.g. "Sahlgrenska".
     * @param shortRouteName The short version of the route name, usually simply a line number
     *                       (e.g. "55"), but can also be longer, e.g. "Grön Express".
     * @param journeyID from Vasttrafik. This is the unique identification number for a certain
     *                  route. It gets changed any time the vehicle arrives to the end stop and
     *                  continues in the opposite direction.
     * @param arrivalTime a date containing the day and time of the real, not scheduled, arrival.
     * @param flags a list of the vehicles flag. If the vehicle has no flags, this should be an
     *              empty list (i.e. not null).
     * @throws NullPointerException if any parameter is null.
     */
    public ArrivingVehicle(@NonNull String destination, @NonNull String shortRouteName,
                           String journeyID, @NonNull Date arrivalTime, @NonNull List<IFlag> flags){
        super(destination, shortRouteName, journeyID);
        this.arrivalTime = new Date(arrivalTime.getTime());
        this.flags = new ArrayList<>(flags);
    }

    @Override
    public Date getArrivalTime() {
        return new Date(this.arrivalTime.getTime());
    }

    @Override
    public List<IFlag> getFlags() {
        return new ArrayList<>(this.flags);
    }

    @Override
    public long getTimeToArrival() {
        return arrivalTime.getTime() - System.currentTimeMillis();
    }

    /**
     * Compares this vehicle to another arriving vehicle.
     *
     * @return -1 if this vehicle arrives later than the other vehicle, 1 if this vehicle arrives
     * sooner than the other vehicle, and 0 if they arrive at the same time.
     */
    @Override
    public int compareTo(@NonNull IArrivingVehicle other) {
        long thisTimeToArrival = this.getTimeToArrival();
        long otherTimeToArrival = other.getTimeToArrival();

        if (thisTimeToArrival > otherTimeToArrival) {
            return 1;
        } else if (thisTimeToArrival < otherTimeToArrival) {
            return -1;
        } else {
            return 0;
        }
    }
}
