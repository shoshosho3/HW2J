/**
 * This class represents a clock with hour, minute and second
 */
class AccurateClock extends Clock {
    private int seconds;

    /**
     * constructor
     *
     * @param hour    integer representing hour
     * @param minute  integer representing minute
     * @param seconds integer representing second
     */
    public AccurateClock(int hour, int minute, int seconds) {
        super(hour, minute);
        setSeconds(seconds);
    }

    /**
     * This function sets seconds to given value if valid, otherwise to 0
     *
     * @param seconds integer representing seconds
     */
    public void setSeconds(int seconds) {
        if (seconds > 59 || seconds < 0)
            seconds = Clock.OUT_OF_RANGE_VALUE;
        this.seconds = seconds;
    }

    /**
     * @return unique hash code according to hour, minute and seconds
     */
    @Override
    public int hashCode() {
        return 3600 * getHour() + 60 * getMinute() + seconds;
    }

    /**
     * @return string with hour, minute and seconds
     */
    @Override
    public String toString() {
        return super.toString() + String.format(":%2d",seconds).replace(' ', '0');
    }
}
