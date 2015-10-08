package com.alive_n_clickin.commutity.event;

import com.alive_n_clickin.commutity.util.event.IEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * An event for when the list of nearby wifi networks changes. The event contains information about
 * all networks that are currently in range.
 */
public class NewWifiNetworksInRangeEvent implements IEvent {
    private List<String> BSSIDs;

    /**
     * Initiates a new NewWifiNetworksInRangeEvent.
     *
     * @param BSSIDs a list of the BSSID:s of all networks that are currently in range.
     */
    public NewWifiNetworksInRangeEvent(List<String> BSSIDs) {
        this.BSSIDs = new ArrayList<>(BSSIDs);
    }

    /**
     * @return the BSSID:s of all networks that are currently in range.
     */
    public List<String> getBSSIDs() {
        return new ArrayList<>(this.BSSIDs);
    }
}
