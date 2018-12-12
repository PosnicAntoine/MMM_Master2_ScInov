package fr.istic.mmm.scinov.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.PropertyName;

import java.util.ArrayList;
import java.util.List;

@IgnoreExtraProperties
public class Event implements Parcelable {

    private String id;
    private String name;
    private String type;
    private String theme;
    private String link;
    private String address;
    private String city;
    private String zipcode;
    private String dates;
    private String descriptionShort;
    private String description;
    private String hours;
    private String imageUrl;
    private String keywords;
    private List<Float> geolocation = new ArrayList<>();

    public Event() {
    }

    @PropertyName("identifiant")
    public String getId() {
        return id;
    }

    @PropertyName("identifiant")
    public void setId(String id) {
        this.id = id;
    }

    @PropertyName("titre_fr")
    public String getName() {
        return name;
    }

    @PropertyName("titre_fr")
    public void setName(String name) {
        this.name = name;
    }

    @PropertyName("type_d_animation")
    public String getType() {
        return type;
    }

    @PropertyName("type_d_animation")
    public void setType(String type) {
        this.type = type;
    }

    @PropertyName("thematiques")
    public String getTheme() {
        return theme;
    }

    @PropertyName("thematiques")
    public void setTheme(String theme) {
        this.theme = theme;
    }

    @PropertyName("lien_canonique")
    public String getLink() {
        return link;
    }

    @PropertyName("lien_canonique")
    public void setLink(String link) {
        this.link = link;
    }

    @PropertyName("adresse")
    public String getAddress() {
        return address;
    }

    @PropertyName("adresse")
    public void setAddress(String address) {
        this.address = address;
    }

    @PropertyName("ville")
    public String getCity() {
        return city;
    }

    @PropertyName("ville")
    public void setCity(String city) {
        this.city = city;
    }

    @PropertyName("code_postal")
    public String getZipcode() {
        return zipcode;
    }

    @PropertyName("code_postal")
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @PropertyName("dates")
    public String getDates() {
        return dates;
    }

    @PropertyName("dates")
    public void setDates(String dates) {
        this.dates = dates;
    }

    @PropertyName("description_fr")
    public String getDescriptionShort() {
        return descriptionShort;
    }

    @PropertyName("description_fr")
    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }

    @PropertyName("description_longue_fr")
    public String getDescription() {
        return description;
    }

    @PropertyName("description_longue_fr")
    public void setDescription(String description) {
        this.description = description;
    }

    @PropertyName("horaires_detailles_fr")
    public String getHours() {
        return hours;
    }

    @PropertyName("horaires_detailles_fr")
    public void setHours(String hours) {
        this.hours = hours;
    }

    @PropertyName("image_source")
    public String getImageUrl() {
        return imageUrl;
    }

    @PropertyName("image_source")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @PropertyName("mots_cles_fr")
    public String getKeywords() {
        return keywords;
    }

    @PropertyName("mots_cles_fr")
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", theme='" + theme + '\'' +
                ", link='" + link + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", dates='" + dates + '\'' +
                ", descriptionShort='" + descriptionShort + '\'' +
                ", description='" + description + '\'' +
                ", hours='" + hours + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", keywords='" + keywords + '\'' +
                ", geolocation='" + geolocation + '\'' +
                '}';
    }

    @PropertyName("geolocalisation")
    public List<Float> getGeolocation() {
        return geolocation;
    }

    @PropertyName("geolocalisation")
    public void setGeolocation(List<Float> geolocation) {
        this.geolocation = geolocation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    protected Event(Parcel in) {
        id = in.readString();
        name = in.readString();
        type = in.readString();
        theme = in.readString();
        link = in.readString();
        address = in.readString();
        city = in.readString();
        zipcode = in.readString();
        dates = in.readString();
        descriptionShort = in.readString();
        description = in.readString();
        hours= in.readString();
        imageUrl= in.readString();
        keywords= in.readString();
        in.readList(geolocation,null);

    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(type);
        dest.writeString(theme);
        dest.writeString(link);
        dest.writeString(address);
        dest.writeString(city);
        dest.writeString(zipcode);
        dest.writeString(dates);
        dest.writeString(descriptionShort);
        dest.writeString(description);
        dest.writeString(hours);
        dest.writeString(imageUrl);
        dest.writeString(keywords);
        dest.writeList(geolocation);

    }

}