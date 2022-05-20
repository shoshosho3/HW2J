class AccurateClock extends Clock {
    private int seconds;

    public AccurateClock(int hour, int minute, int seconds) {
        super(hour, minute);
        setSeconds(seconds);
    }

    public void setSeconds(int seconds) {
        if (seconds > 59 || seconds < 0)
            seconds = Clock.OUT_OF_RANGE_VALUE;
        this.seconds = seconds;
    }


    @Override
    public int hashCode() {
        return 3600 * getHour() + 60 * getMinute() + seconds;
    }

    @Override
    public String toString() {
        return super.toString() + ":" + seconds;
    }
}
