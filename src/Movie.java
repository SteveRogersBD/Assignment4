class Movie implements Comparable {
    private int year;
    private String title;

    public Movie(String t, int y)
    {
        this.title = t;
        this.year = y;
    }
    int getYear() { return year; }
    String getTitle() { return title;}

    @Override
    public String toString() {
        return year+" "+title;
    }


    @Override
    public int compareTo(Object obj) {
        Movie movie = (Movie) obj;
        int a = this.year;
        int b = movie.year;

        if(a>b) return 1;
        else if(a<b) return -1;
        return 0;
    }

}