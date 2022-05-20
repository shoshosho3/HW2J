class Clock {
    private int hour;
    private int minute;

    protected static final int OUT_OF_RANGE_VALUE = 0;

    /**
     * constructor
     *
     * @param hour integer representing hour
     * @param minute integer representing minute
     */
    public Clock(int hour, int minute) {
        setHour(hour);
        setMinute(minute);
    }

    /**
     *
     * @return hour value
     */
    public int getHour() {
        return hour;
    }

    /**
     * This function sets hour to given value if valid, otherwise to 0
     *
     * @param hour integer representing hour
     */
    public void setHour(int hour) {
        if (hour > 23 || hour < 0)
            hour = OUT_OF_RANGE_VALUE;
        this.hour = hour;
    }

    /**
     *
     * @return minute value
     */
    public int getMinute() {
        return minute;
    }

    /**
     * This function sets minute to given value if valid, otherwise to 0
     *
     * @param minute integer representing minute
     */
    public void setMinute(int minute) {
        if (minute > 59 || minute < 0)
            minute = OUT_OF_RANGE_VALUE;

        this.minute = minute;
    }


    /**
     *
     * @return unique hash code according to hour and minute
     */
    @Override
    public int hashCode() {
        return 60 * hour + minute;
    }


    /**
     *
     * @param other other object being tested
     * @return true if this clock and other are equal otherwise false
     */
    @Override
    public boolean equals(Object other) {
        if(other == null) return false;
        if(!(other instanceof Clock)) return false;
        Clock clockOther = (Clock) other;
        return clockOther.hashCode() == hashCode();
    }

    /**
     *
     * @return string with hour and minute
     */
    @Override
    public String toString() {
        return hour + ":" + minute;
    }
}