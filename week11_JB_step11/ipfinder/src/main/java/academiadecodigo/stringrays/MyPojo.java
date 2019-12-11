package academiadecodigo.stringrays;

public class MyPojo {

    private String ip;
    private String hostname;
    private String city;
    private String region;
    private String country;
    private String loc;
    private String org;
    private String postal;
    private String timezone;
    private String readme;



    public String getHostname() {
        return hostname;
    }

    public String getIp() {
        return ip;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getLoc() {
        return loc;
    }

    public String getOrg() {
        return org;
    }

    public String getPostal() {
        return postal;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getReadme() {
        return readme;
    }

    @Override
    public String toString() {
        return "MyPojo{\n" +
                "\n ip: '" + ip + '\'' +
                "\n city: '" + city + '\'' +
                "\n region: '" + region + '\'' +
                "\n country: '" + country + '\'' +
                "\n loc: '" + loc + '\'' +
                "\n org: '" + org + '\'' +
                "\n postal: '" + postal + '\'' +
                "\n timezone: '" + timezone + '\'' +
                "\n readme: '" + readme + '\'' +
                "\n}";
    }
}
